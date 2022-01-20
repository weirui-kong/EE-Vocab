package VocabData;

public enum BookType {
    GRE {
        @Override
        public String toString() {
            return "GRE";
        }

        public String getLocalCSV() {
            return "GRE.csv";
        }
    },
    IELTS {
        @Override
        public String toString() {
            return "IELTS";
        }

        public String getLocalCSV() {
            return "IELTS.csv";
        }
    },
    GMAT {
        @Override
        public String toString() {
            return "GMAT";
        }

        public String getLocalCSV() {
            return "GMAT.csv";
        }
    },
}
