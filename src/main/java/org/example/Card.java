package org.example;

public class Card {
    private Suits suit;
    private char symbol;
    private int value;

    public Card(Suits suit,char symbol){
        this.suit = suit;
        this.symbol = symbol;
        this.value = getValueFromSymbol(symbol);
    }

    public Suits getSuit() {
        return suit;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }

    public int getValueFromSymbol(char symbol){
        if(Character.isDigit(symbol)){
            return Integer.parseInt(String.valueOf(symbol));
        } else {
            switch(symbol){
                case'J':
                    return 11;
                case'Q':
                    return 12;
                case'K':
                    return 13;
                case'A':
                    return 14;
                default:
                    return -1;
            }
        }


    }

    public void printCardDetails(){
        System.out.println("Suit: "+this.suit+", symbol: "+this.symbol+", value: "+this.value);
    }




}
