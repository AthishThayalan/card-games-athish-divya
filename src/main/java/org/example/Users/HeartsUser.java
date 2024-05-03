package org.example.Users;

import org.example.Deck.*;

import java.util.ArrayList;
import java.util.List;

public class HeartsUser extends User {
    private final List<Card> SCORING_CARDS = new ArrayList<Card>();
    private List<Integer> scores;
    private int amountOfHeartsCollected;
    private boolean hasQueenOfSpade;

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }

    public HeartsUser(String name) {
        super(name);
        scores = new ArrayList<Integer>();
        for (FaceValue face : FaceValue.values())
            SCORING_CARDS.add(new Card(Suits.hearts, face));
        SCORING_CARDS.add(new Card(Suits.spades, FaceValue.QUEEN));
        newTrick();
    }

    public void newTrick() {
        amountOfHeartsCollected = 0;
        hasQueenOfSpade = false;
    }

    public void sortHand() {
        getCardsInHand().sort(new SortBySuit());
        getCardsInHand().sort(new SortByValue());
    }

    public Card[] selectThreeCardsToBePassed() {
        Card[] cardsToBePassed = new Card[3];
        //To be chosen by the user
        return cardsToBePassed;
    }

    public void addThreeCards(Card[] cards) {
        for (Card card : cards)
            addCard(card);
    }

    public boolean has2OfClubs() {
        for (Card card : getCardsInHand()) {
            if (card.equals(new Card(Suits.clubs, FaceValue.TWO)))
                return true;
        }
        return false;
    }

    public boolean hasShotTheMoon() {
        return findScore() == 26;
    }

    public void addCardToPile(Card card) {
        if (card.getSuit() == Suits.hearts)
            amountOfHeartsCollected++;
        if (card.getSuit() == Suits.spades && card.getFace() == FaceValue.QUEEN)
            hasQueenOfSpade = true;
    }

    public int findScore() {
        return hasQueenOfSpade ? 13 + amountOfHeartsCollected : amountOfHeartsCollected;
    }

    public void updateScores() {
        scores.add(findScore());
    }

    public int totalScore() {
        return scores.stream().reduce(Integer::sum).orElse(0);
    }

    public List<Integer> getScores() {
        return scores;
    }

    public int getAmountOfHeartsCollected() {
        return amountOfHeartsCollected;
    }

    public boolean isHasQueenOfSpade() {
        return hasQueenOfSpade;
    }
}
