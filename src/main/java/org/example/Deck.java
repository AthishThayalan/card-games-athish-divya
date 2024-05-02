package org.example;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
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
    public void shuffleDeck(){
        Collections.shuffle(deckOfCards);
    }

    public  Card dealCard(){
        return deckOfCards.remove(deckOfCards.size()-1);
    }

    public int getDeckSize(){
        return deckOfCards.size();
    }

    public void printDeck(){
        deckOfCards.forEach(Card::printCardDetails);
    }

}
