package org.example.Users;

import org.example.Deck.Card;

public class BlackjackUser extends User {


    private double bet;

    public BlackjackUser(String name) {
        super(name);

    }

    public void setBet(double bet) {
        this.bet = bet;
    }

    public double getBet() {
        return bet;
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
