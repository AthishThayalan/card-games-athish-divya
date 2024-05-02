package org.example.Users;

import org.example.Deck.*;

import java.util.ArrayList;
import java.util.List;

public class HeartsUser extends User {

    private List<Integer> scores;
    private List<Card> collectedScoringCards;

    public HeartsUser(String name) {
        super(name);
        scores = new ArrayList<Integer>();
        collectedScoringCards = new ArrayList<Card>();
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
        return false;
    }

    public int findScore() {
        return 0;
    }

    public void updateScores() {
        scores.add(findScore());
    }

}
