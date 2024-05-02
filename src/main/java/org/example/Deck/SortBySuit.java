package org.example.Deck;

import java.util.Comparator;

public class SortBySuit implements Comparator<Card> {

    @Override
    public int compare(Card card1, Card card2) {
        System.out.println(card1.getSuitSymbol());
        if(card1.getSuitSymbol().equals(card2.getSuitSymbol()))
            return card1.getValue()-card2.getValue();
        return card1.getSuitSymbol().compareTo(card2.getSuitSymbol());
    }
}
