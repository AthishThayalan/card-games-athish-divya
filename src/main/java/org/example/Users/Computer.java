package org.example.Users;

import org.example.Deck.Card;

public class Computer extends User {

    public Computer() {
        super("CPU");
    }

    @Override
    public int getHandValue() {
        int sum = 0;
        for (Card card : cardsInHand) {
            sum += card.getValue();
        }
        return sum;
    }
}
