package Entities;

public enum ServiceConstituent {
    TERM,
    PROPERTY;

    private int term;
    private String property;

    public int getTerm() {
        if (this == ServiceConstituent.TERM) {
            return term;
        }
        else return -1;
    }

    public void setTerm(int term) {
        if (this == ServiceConstituent.TERM) {
            this.term = term;
        }
    }

    public String getProperty() {
        if (this == ServiceConstituent.PROPERTY) {
            return property;
        }
        else return "";
    }

    public void setProperty(String property) {
        if (this == ServiceConstituent.PROPERTY) {
            this.property = property;
        }
    }
}
