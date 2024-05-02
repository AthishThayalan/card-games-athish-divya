package org.example.Deck;

import java.util.Comparator;

public class SortByValue implements Comparator<Card> {

    @Override
    public int compare(Card card1, Card card2) {
        return card1.getValue()-card2.getValue();
    }
}
