public interface Type {

    public int getTaille();

    public static class Entier implements Type {
        public int getTaille() {
            return 1;
        }
    }

    public static class Booleen implements Type {
        public int getTaille() {
            return 1;
        }
    }

    public static class Tableau implements Type {
        int taille;
        Type type;

        public Tableau (int taille, Type type) {
            this.taille = taille;
            this.type = type;
        }

        public int getTaille() {
            return this.taille;
        }

        public Type getType() {
            return this.type;
        }
    }

    public static class Enregistrement implements Type {
        String[] champ;
        Type[] type;

        public Enregistrement(String[] champ, Type[] type) {
            this.champ = champ;
            this.type = type;
        }

        public int getTaille() {
            int res = 0;
            for( Type t:type) {
                res += t.getTaille();
            }
            return res;
        }

        public int getAdresse(String nom) {
            int res = 0;
            int i=0;
            for(; i<type.length;i++) {
                if (champ[i].equals(nom))
                    return res;
                res += type[i].getTaille();
            }
            return -1;
        }
        public Type getType(String nom) {
            int i=0;
            for(; i<type.length;i++) {
                if (champ[i].equals(nom))
                    return type[i];
            }
            return null;
        }
    }

    public static class Proc implements Type {

        @Override
        public int getTaille() {
            return 0;
        }
    }
}
