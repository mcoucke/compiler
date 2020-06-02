grammar Pascal;

@header {
    import java.util.*;
}

@parser::members {
    public HashMap<String,Type> tableType = new HashMap<String,Type>();
    public TableSymbole table = new TableSymbole();
    ArrayList<Instruction> pCode = new ArrayList<Instruction>();

    boolean pasErreur = true;
    int cpt = 0;
    ArrayList<Type.Parametre> param;

    public  Instruction[] lire() throws Exception {
        program();
        if (_syntaxErrors!=0 || !pasErreur)
            return null;
        else
            return pCode.toArray(new Instruction[]{});
    }
}


program: 'program' ID ';' block '.' {
    pCode.add(new Instruction.HLT());
};

block: (deftypes)? (vars)? {
    pCode.add(new Instruction.INC(table.getTaille()));
    Instruction.BRN brn = new Instruction.BRN(-1);
    pCode.add(brn);
} defprocs? {
    brn.setParam(pCode.size());
} insts;

deftypes : 'type' deftype (';' deftype)*;

deftype : ID '=' type {
    tableType.put($ID.text, $type.mytype);
};

vars : 'var' var (';' var)*;

var : x=ID {
    ArrayList<String> mesVar = new ArrayList<String>();
    mesVar.add($x.text);
}
(',' y=ID { mesVar.add($y.text); } )*
':' type {
{
   for (String v:mesVar) {
       table.put(v,$type.mytype);
   }
}
};

defprocs : defproc (';' defproc)*;

defproc : 'proc' ID {
    Type.Proc proc = new Type.Proc();
    table.put($ID.text, proc, pCode.size());
    table.downLevel();
}

'(' (d=defparams {
        proc.param = $d.mytype;
        for (Type.Parametre p:proc.param)
            proc.taille += p.getTaille();
        int ad = -proc.taille-2;
        for (int i=0; i<proc.param.size(); i++) {
            table.putParametre($defparams.id.get(i), proc.param.get(i), ad);
            ad += proc.param.get(i).getTaille();
        }
    })?
')' vars? {
        pCode.add(new Instruction.INC(table.getTaille()));
}
    insts {
        pCode.add(new Instruction.RET(0));
        table.upLevel();
};

defparams returns[ArrayList<Type.Parametre> mytype,
    ArrayList<String> id]:
    {
        $mytype = new ArrayList<Type.Parametre>();
        $id = new ArrayList<String>();
    }
    p0=defparam
    {
        $mytype.add($p0.mytype);
        $id.add($p0.id);
    }
    (',' p1=defparam
        {
            $mytype.add($p1.mytype);
            $id.add($p1.id);
        }
    )*;

defparam returns[Type.Parametre mytype, String id] : 'var' ID ':' type
    {
        $mytype = new Type.Parametre($type.mytype, false);
        $id = $ID.text;
    }
| ID ':' type
    {
        $mytype = new Type.Parametre($type.mytype, true);
        $id = $ID.text;
    }
;


type returns[Type mytype]:
    'integer' { $mytype = new Type.Entier(); }
    | 'boolean' { $mytype = new Type.Booleen(); }
    | 'array' '[' INT ']' 'of' type {
        $mytype = new Type.Tableau($INT.int, $type.mytype);
    }
    | ID { $mytype = tableType.get($ID.text); };

insts : 'begin' inst (';' inst)* 'end';

inst : insts | affect | read | write | forinst | ifinst | whileinst | repeatinst | callproc;

read : 'read' '(' x=adresse ')' {
    pCode.add(new Instruction.INN());
    pCode.add(new Instruction.STO(1));
};

write : 'write' '(' expr ')' {
    pCode.add(new Instruction.PRN());
};

affect : x=adresse ':=' (expr | boolval)  {
    pCode.add(new Instruction.STO(1));
};

forinst : 'for' adresse {
    int ad = $adresse.ad;
} ':=' expr {
    pCode.add(new Instruction.STO(1));
    int debut = pCode.size();
} 'to' expr {
    pCode.add(new Instruction.LDA(ad));
    pCode.add(new Instruction.LDV(1));
    pCode.add(new Instruction.GEQ());
    Instruction.BZE bze = new Instruction.BZE(-1);
    pCode.add(bze);
} 'do' insts {
    pCode.add(new Instruction.LDA(ad));
    pCode.add(new Instruction.LDA(ad));
    pCode.add(new Instruction.LDV(1));
    pCode.add(new Instruction.LDI(1));
    pCode.add(new Instruction.ADD());
    pCode.add(new Instruction.STO(1));
    pCode.add(new Instruction.BRN(debut));
    bze.setParam(pCode.size());
};

ifinst : 'if' comp {
    Instruction.BZE bze = new Instruction.BZE(-1);
    pCode.add(bze);
} 'then' insts {
    bze.setParam(pCode.size());
} ('else' {
    Instruction.BRN brn = new Instruction.BRN(-1);
    pCode.add(brn);
    bze.setParam(pCode.size());
} insts {
    brn.setParam(pCode.size());
})?;

whileinst : 'while' {
    int debut = pCode.size();
} comp {
    Instruction.BZE bze = new Instruction.BZE(-1);
    pCode.add(bze);
} 'do' insts {
    pCode.add(new Instruction.BRN(debut));
    bze.setParam(pCode.size());
};

repeatinst : 'repeat' {
    int debut = pCode.size();
} inst (';' inst)* 'until' comp {
    Instruction.BZE bze = new Instruction.BZE(debut);
    pCode.add(bze);
};

callproc : ID
    {
        Variable v = table.get($ID.text);
        Type.Proc proc = (Type.Proc) v.getType();
        param = proc.param;
        cpt = 0;
    } '(' params? ')'
    {
        pCode.add(new Instruction.CAL(v.getAdr()));
    }
;

params : param (',' param)*;

param : {param.get(cpt).parValeur}? expr {cpt++;} | adresse {cpt++;};

comp : expr '=' (expr|boolval) {
    pCode.add(new Instruction.EQL());
} | expr '!=' (expr|boolval) {
    pCode.add(new Instruction.NEQ());
} | expr '>=' expr {
    pCode.add(new Instruction.GEQ());
} | expr '<=' expr {
    pCode.add(new Instruction.LEQ());
} | expr '>' expr  {
    pCode.add(new Instruction.GTR());
} | expr '<' expr {
    pCode.add(new Instruction.LSS());
};

boolval : 'true' {
    pCode.add(new Instruction.LDI(1));
} | 'false' {
    pCode.add(new Instruction.LDI(0));
};

expr : i=INT {
    pCode.add(new Instruction.LDI($i.int));
} (operation)? | adresse {
    pCode.add(new Instruction.LDV($adresse.mytype.getTaille()));
} (operation)?;

operation : '*' multexpr
| '/' divexpr
| '+' expr {
    pCode.add(new Instruction.ADD());
} | '-' expr {
    pCode.add(new Instruction.SUB());
};

multexpr : i=INT {
   pCode.add(new Instruction.LDI($i.int));
   pCode.add(new Instruction.MUL());
} (operation)? | adresse {
   pCode.add(new Instruction.LDV($adresse.mytype.getTaille()));
   pCode.add(new Instruction.MUL());
} (operation)?;

divexpr : i=INT {
   pCode.add(new Instruction.LDI($i.int));
   pCode.add(new Instruction.DIV());
} (operation)? | adresse {
   pCode.add(new Instruction.LDV($adresse.mytype.getTaille()));
   pCode.add(new Instruction.DIV());
} (operation)?;

adresse returns[Type mytype, int ad]: x=ID {
        if (!table.containsKey($x.text))
            pasErreur = false;
        else {
            Variable v=table.get($x.text);
            if (v.getType() instanceof Type.Parametre) {
                Type.Parametre p = (Type.Parametre) v.getType();
                $mytype = p.type;
                $ad = v.getAdr();
                pCode.add(new Instruction.LDL($ad));
                if (!p.parValeur)
                    pCode.add(new Instruction.LDV(1));
            }
            else {
                $mytype = v.getType();
                $ad = v.getAdr();
                if (v.isGlobale())
                    pCode.add(new Instruction.LDA($ad));
                else
                    pCode.add(new Instruction.LDL($ad));
            }
        }
        }
        ('[' expr ']' {
            Type.Tableau t= (Type.Tableau) $mytype;
            $mytype =  t.getType();
            if (t.type.getTaille() !=1 ) {
                pCode.add(new Instruction.LDI(t.type.getTaille()));
                pCode.add(new Instruction.MUL());
            }
            pCode.add(new Instruction.ADD());
        }
        | '.' c=ID {
            Type.Enregistrement t= (Type.Enregistrement) $mytype;
            $mytype =  t.getType($c.text);
            pCode.add(new Instruction.LDI(t.getAdresse($c.text)));
            pCode.add(new Instruction.ADD());
        }
        )*;

ID :[a-z]+;
INT : [1-9][0-9]*|[0];
WS : [ \r\t\n]+ -> skip;