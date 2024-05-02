package org.example.Deck;

public enum Suits {
    diamonds("♦"),spades("♠"),clubs("♣"),hearts("♥");

    private final String suitSymbol;

    Suits(String suitSymbol) {
        this.suitSymbol = suitSymbol;
    }

    public String getSuitSymbol() {
        return suitSymbol;
    }
}
