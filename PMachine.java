public class PMachine {
    //LiaisonSerie liaisonSerie;
    Instruction pcode[];
    int mem[] = new int[1000];
    int base = 0;
    int SP = 0;
    int PC = 0;
    boolean run = false;


    public PMachine(Instruction[] pcode /*, LiaisonSerie liaisonSerie*/)
    {
        this.pcode = pcode;
//        this.liaisonSerie=liaisonSerie;
    }

    public void exec() {
 //       liaisonSerie.open();
        run = true;
        while(run)
            pcode[PC].exec(this);
//        liaisonSerie.close();
    }

    public String toString() {
        StringBuffer res = new StringBuffer();
        for (int i=0; i< pcode.length; i++)
            res.append(i + "\t" + pcode[i] +"\n");
        return res.toString();
    }
}
