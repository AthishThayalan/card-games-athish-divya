package org.example.Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Deck {
    List<Card> deckOfCards = new ArrayList<>();

    public Deck() {
        generateDeck();
    }
    
    public void generateDeck() {
        for (Suits suit : Suits.values()) {
            for (FaceValue face : FaceValue.values()) {
                deckOfCards.add(new Card(suit, face));
            }
        }
    }

    public void resetDeck() {
        generateDeck();
        shuffleDeck();
    }

    public void sortDeck() {
        deckOfCards.sort(new SortByValue());
    }

    public void sortDeck(CardComparator comparator) {
        if (comparator == CardComparator.SUIT)
            deckOfCards.sort(new SortBySuit());
        else
            deckOfCards.sort(new SortByValue());
    }

    public void shuffleDeck() {
        Collections.shuffle(deckOfCards);
    }

    public Card dealCard() {
        return deckOfCards.remove(deckOfCards.size() - 1);
    }

    public int getDeckSize() {
        return deckOfCards.size();
    }

    public void printDeck() {
        deckOfCards.forEach(x -> System.out.println(x.toString()));
    }

}
