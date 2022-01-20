package VocabRaw;

public enum BookType {
    GRE {
        @Override
        public String toString() {
            return "GRE";
        }

        public String getLocalCSV() {
            return "GRE.csv";
        }
    }
}
