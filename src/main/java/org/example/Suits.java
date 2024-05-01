package org.example;

public enum Suits {
    diamonds("♦"),spades("♠"),clubs("♣"),hearts("♥");

    private String suitSymbol;

    Suits(String suitSymbol) {
        this.suitSymbol = suitSymbol;
    }

    public String getSuitSymbol() {
        return suitSymbol;
    }
}
