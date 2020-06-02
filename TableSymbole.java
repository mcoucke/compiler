import java.util.HashMap;

public class TableSymbole {
    HashMap<String, Variable> tableGlobale = new HashMap<>();
    int tailleGlobale = 0;

    HashMap<String, Variable> tableLocale;
    int tailleLocale;

    boolean isGlobale = true;

    public void downLevel() {
        isGlobale = false;
        tableLocale = new HashMap<>();
        tailleLocale = 0;
    }

    public void upLevel() {
        isGlobale = true;
        tableLocale = null;
        tailleLocale = -1;
    }

    public Variable get(String nom) {
        Variable var = null;
        if (!isGlobale) {
            var = tableLocale.get(nom);
        }
        return var == null ? tableGlobale.get(nom) : var;
    }

    public boolean containsKey(String nom) {
        return (!isGlobale && tableLocale.containsKey(nom)) || tableGlobale.containsKey(nom);
    }

    public void put(String nom, Type type) {
        if (isGlobale) {
            tableGlobale.put(nom, new Variable(tailleGlobale, type, true));
            tailleGlobale += type.getTaille();
        } else {
            tableLocale.put(nom, new Variable(tailleLocale, type, false));
            tailleLocale += type.getTaille();
        }
    }

    public void put(String nom, Type type, int adresse) {
        tableGlobale.put(nom, new Variable(adresse, type, true));
    }

    public int getTaille() {
        return isGlobale ? tailleGlobale : tailleLocale;
    }

    public void putParametre(String nom, Type.Parametre type, int adresse) {
        tableGlobale.put(nom, new Variable(adresse, type, false));
    }
}
