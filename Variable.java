public class Variable {
    private int adr;
    private Type type;
    private boolean isGlobale;

    public Variable(int adr, Type type, boolean isGlobale) {
        this.adr = adr;
        this.type = type;
        this.isGlobale = isGlobale;
    }

    public int getAdr() {
        return adr;
    }

    public void setAdr(int adr) {
        this.adr = adr;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isGlobale() {
        return isGlobale;
    }

    public void setGlobale(boolean isGlobale) {
        this.isGlobale = isGlobale;
    }
}
