package org.example.Users;

import org.example.Deck.Card;

public class BlackjackUser extends User {

    public BlackjackUser(String name) {
        super(name);
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
