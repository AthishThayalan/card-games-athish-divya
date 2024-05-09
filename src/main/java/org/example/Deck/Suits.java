package org.example.Deck;

public enum Suits {
    DIAMONDS("♦"), SPADES("♠"), CLUBS("♣"), HEARTS("♥");

    private final String suitSymbol;

    Suits(String suitSymbol) {
        this.suitSymbol = suitSymbol;
    }

    public String getSuitSymbol() {
        return suitSymbol;
    }
}
