package org.example.Deck;

public enum FaceValue {
    TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"),
    NINE("9"), TEN("10"), JACK("J"), QUEEN("Q"), KING("K"), ACE("A");

    private final String faceSymbol;

    FaceValue(String symbol){
        this.faceSymbol = symbol;
    }

    public String getFaceSymbol() {
        return faceSymbol;
    }
}
