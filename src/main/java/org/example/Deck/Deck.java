package org.example.Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    List<Card> deckOfCards = new ArrayList<>();

    public Deck(){
        generateDeck();
    }

    public void generateDeck(){
        for(Suits suit:Suits.values()){
            for(FaceValue face:FaceValue.values()){
                deckOfCards.add(new Card(suit,face));
            }
        }
    }
    public void shuffleDeck(){
        Collections.shuffle(deckOfCards);
    }

    public Card dealCard(){
        return deckOfCards.remove(deckOfCards.size()-1);
    }

    public int getDeckSize(){
        return deckOfCards.size();
    }

    public void printDeck(){
        deckOfCards.forEach(Card::printCardDetails);
    }

}
