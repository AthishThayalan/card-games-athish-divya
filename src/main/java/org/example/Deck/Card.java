package org.example.Deck;

public class Card {
    private Suits suit;
    private FaceValue face;
    private int value;

    public Card(Suits suit,FaceValue face){
        this.suit = suit;
        this.face = face;
        value = getValueFromSymbol(face.getSymbol());
    }

    public Suits getSuit() {
        return suit;
    }

    public String getSymbol() {
        return face.getSymbol();
    }

    public FaceValue getFace() {
        return face;
    }

    public int getValue() {
        return value;
    }

    public int getValueFromSymbol(String symbol){
        if(Character.isDigit(symbol.charAt(0))){
            return Integer.parseInt(symbol);
        } else {
            switch(symbol){
                case"J":
                    return 11;
                case"Q":
                    return 12;
                case"K":
                    return 13;
                case"A":
                    return 14;
                default:
                    return -1;
            }
        }
    }

    public void printCardDetails(){
        System.out.println("Suit: "+suit+", symbol: "+face.getSymbol()+", value: "+value);
    }

}
