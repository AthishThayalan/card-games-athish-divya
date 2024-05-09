package org.example.Users;

import org.example.Deck.Card;
import org.example.Deck.Suits;

import java.util.*;

public class HeartsComputerUser extends HeartsUser {
    private final Random random = new Random();

    public HeartsComputerUser(String name) {
        super(name);
    }

    @Override
    public Card[] selectThreeCardsToBePassed() {
        Card[] cardsToBePassed = new Card[3];
        int randomIndex;
        for (int i = 0; i < 3; i++) {
            randomIndex = random.nextInt(amountOfCardsInHand());
            cardsToBePassed[i] = playCard(randomIndex + 1);
        }
        return cardsToBePassed;
    }

    @Override
    public Card selectOneCard(ArrayList<Card> cards) {
        Suits suit = cards.get(0).getSuit();
        int randomIndex = random.nextInt(amountOfCardsInHand());
        if (amountOfCardsInHand(suit) > 0) {
            while (getCardsInHand().get(randomIndex).getSuit() != suit) {
                randomIndex = random.nextInt(amountOfCardsInHand());
            }
        }
        return playCard(randomIndex + 1);
    }

    @Override
    public Card selectOneCard(boolean isHeartBroken) {
        int randomIndex = random.nextInt(amountOfCardsInHand());
        if (!isHeartBroken)
            while (getCardsInHand().get(randomIndex).getSuit() == Suits.HEARTS) {
                randomIndex = random.nextInt(amountOfCardsInHand());
            }
        return playCard(randomIndex + 1);
    }
}
