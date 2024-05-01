package org.example;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    List<Card> deckOfCards = new ArrayList<>();

    public Deck(){
        generateDeck();
    }
    
    public void generateDeck(){
        String[] symbolStr = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        for(Suits suit:Suits.values()){
            for(String symbol:symbolStr){
                deckOfCards.add(new Card(suit,symbol));
            }
        }
    }

    public int getDeckSize(){
        return deckOfCards.size();
    }

    public void printDeck(){
        deckOfCards.forEach(Card::printCardDetails);
    }


}
