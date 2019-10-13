package toto.tarolo;

public enum Eredmeny {
    _1("1"),
    _2("2"),
    _X("X");

    private String value;

    private Eredmeny(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

