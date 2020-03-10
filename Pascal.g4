grammar Pascal;

@header {
    import java.util.*;
}

@parser::members {
    public HashMap<String,Type> tableType = new HashMap<String,Type>();
    public TableSymbole table = new TableSymbole();
    ArrayList<Instruction> pCode = new ArrayList<Instruction>();

    boolean pasErreur = true;

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
} (defprocs)? {
    brn.setParam(pCode.size());
} insts;

deftypes : 'type' deftype (';' deftype)*;

deftype : ID '=' type {
    tableType.put($ID.text, $type.myType);
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
       table.put(v,$type.myType);
   }
}
};

defprocs : defproc (';' defproc)*;

defproc : 'proc' ID {
    table.put($ID.text, new Type.Proc(), pCode.size());
    table.downLevel();
} '(' (var (',' var)*)? ')' (vars)? {
    pCode.add(new Instruction.INC(table.getTaille()));
} insts {
    pCode.add(new Instruction.RET(0));
    table.upLevel();
};

type returns[Type myType]:
    'integer' { $myType = new Type.Entier(); }
    | 'boolean' { $myType = new Type.Booleen(); }
    | 'array' '[' INT ']' 'of' type {
        $myType = new Type.Tableau($INT.int, $type.myType);
    }
    | ID { $myType = tableType.get($ID.text); };

insts : 'begin' inst (';' inst)* 'end';

inst : insts | affect | read | write | forinst | ifinst | whileinst | repeatinst | callproc;

read : 'read' '(' x=adresse ')' {
    pCode.add(new Instruction.INN());
    pCode.add(new Instruction.STO(1));
};

write : 'write' '(' expr ')' {
    pCode.add(new Instruction.PRN());
};

affect : x=adresse ':=' expr {
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

callproc : ID '(' ')' {
    int ad = table.get($ID.text).getAdr();
    pCode.add(new Instruction.CAL(ad));
};


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
    pCode.add(new Instruction.LDV(1));
} (operation)?;

operation : '+' expr {
    pCode.add(new Instruction.ADD());
} | '-' expr {
    pCode.add(new Instruction.SUB());
} | '*' expr {
    pCode.add(new Instruction.MUL());
} | '/' expr {
    pCode.add(new Instruction.DIV());
};

adresse returns[Type myType, int ad]: x=ID
{
    if (!table.containsKey($x.text))
        pasErreur = false;
    else {
        Variable var = table.get($x.text);
        $myType = var.getType();
        $ad = var.getAdr();
        if (var.isGlobale()) {
            pCode.add(new Instruction.LDA($ad));
        } else {
            pCode.add(new Instruction.LDL($ad));
        }
    }
}
('[' expr ']' {
    Type.Tableau t = (Type.Tableau) $myType;
    $myType = t.getType();
    if (t.type.getTaille() != 1) {
        pCode.add(new Instruction.LDI(t.type.getTaille()));
        pCode.add(new Instruction.MUL());
    }
    pCode.add(new Instruction.ADD());
})*;

ID:[a-z]+;
INT: [1-9][0-9]*|[0];
WS : [ \r\t\n]+ -> skip;
