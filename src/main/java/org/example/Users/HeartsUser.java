package org.example.Users;

import org.example.Deck.*;

import java.util.ArrayList;
import java.util.List;

public class HeartsUser extends User {
    private final List<Card> SCORING_CARDS = new ArrayList<Card>();
    private List<Integer> scores;
    private List<Card> collectedScoringCards;

    public HeartsUser(String name) {
        super(name);
        scores = new ArrayList<Integer>();
        for (FaceValue face : FaceValue.values())
            SCORING_CARDS.add(new Card(Suits.hearts, face));
        SCORING_CARDS.add(new Card(Suits.spades, FaceValue.QUEEN));
    }

    public void sortHand() {
        getCardsInHand().sort(new SortBySuit());
        getCardsInHand().sort(new SortByValue());
    }

    public Card[] passThreeCards() {
        Card[] cardsToBePassed = new Card[3];
        //To be chosen by the user
        return cardsToBePassed;
    }

    public boolean has2OfClubs() {
        for (Card card : getCardsInHand()) {
            if (card.equals(new Card(Suits.clubs, FaceValue.TWO)))
                return true;
        }
        return false;
    }

    public boolean hasShotTheMoon() {
        for (Card card : SCORING_CARDS) {
            boolean hasCard = false;
            for (Card cardCollected : collectedScoringCards) {
                if (cardCollected.equals(card)) {
                    hasCard = true;
                    break;
                }
            }
            if (!hasCard) {
                return false;
            }
        }
        return true;
    }

    public int findScore() {
        return 0;
    }

    public void updateScores() {
        scores.add(findScore());
    }

}
