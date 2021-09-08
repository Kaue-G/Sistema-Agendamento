package br.pedro.demofc.entities;

public enum Type {
    REUNION(1),DAY(2);

    private final int value;

    Type(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
