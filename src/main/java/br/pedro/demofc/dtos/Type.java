package br.pedro.demofc.dtos;

public enum Type {
    REUNION(1),DAY(2),HOUR(3);

    private final int value;

    Type(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
