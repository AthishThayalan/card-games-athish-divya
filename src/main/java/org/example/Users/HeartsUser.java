package org.example.Users;

import org.example.Deck.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeartsUser extends User {
    private final List<Integer> scores;
    private int amountOfHeartsCollected;
    private boolean hasQueenOfSpade;

    public HeartsUser(String name) {
        super(name);
        scores = new ArrayList<>();
        newRound();
    }

    public void newRound() {
        amountOfHeartsCollected = 0;
        hasQueenOfSpade = false;
    }

    public void sortHand() {
        List<Card> cards = getCardsInHand();
        cards.sort(new SortBySuit());
        setCardsInHand(cards);
    }

    public Card[] selectThreeCardsToBePassed() {
        System.out.println("User selecting cards");
        Card[] cardsToBePassed = new Card[3];
        int[] indexes = new int[3];
        for (int i = 0; i < 3; i++) {
            var indexObject = new Object() {
                int index = 0;
            };
            do {
                System.out.println("Please choose card no " + (i + 1));
                indexObject.index = getInput();
            } while (Arrays.stream(indexes).anyMatch(x -> (int) x == (int) indexObject.index));
            indexes[i] = indexObject.index;
        }
        indexes = Arrays.stream(indexes).sorted().toArray();
        for (int i = 2; i >= 0; i--) {
            cardsToBePassed[i] = playCard(indexes[i]);
        }
        return cardsToBePassed;
    }

    public void addThreeCards(Card[] cards) {
        for (Card card : cards)
            addCard(card);
    }

    public Card selectOneCard(ArrayList<Card> cards) {
        Suits suit = cards.get(0).getSuit();
        System.out.println("Cards in hand:");
        printCards();
        System.out.println("Please choose a card to play");
        int cardToBePlayed = getInput();
        Card card = playCard(cardToBePlayed);
        if (card.getSuit() != suit && amountOfCardsInHand(suit) > 0) {
            System.out.println("Card cannot be selected as it is of the wrong suit.");
            addCard(card);
            sortHand();
            card = selectOneCard(cards);
        }
        return card;
    }

    public int amountOfCardsInHand(Suits suit) {
        return (int) getCardsInHand().stream().filter(card -> card.getSuit() == suit).count();
    }

    public Card selectOneCard(boolean isHeartBroken) {
        System.out.println("Cards in hand:");
        printCards();
        System.out.println("Please choose a card to play");
        int cardToBePlayed = getInput();
        Card card = playCard(cardToBePlayed);
        if (!isHeartBroken && card.getSuit() == Suits.hearts && amountOfCardsInHand(Suits.hearts) != amountOfCardsInHand()) {
            System.out.println("Card cannot be selected as hearts have not been broken.");
            addCard(card);
            sortHand();
            card = selectOneCard(false);
        }
        return card;
    }

    public boolean hasTwoOfClubs() {
        for (Card card : getCardsInHand()) {
            if (card.equals(new Card(Suits.clubs, FaceValue.TWO)))
                return true;
        }
        return false;
    }

    public boolean hasShotTheMoon() {
        return findScore() == 26;
    }

    public void addCardToPile(ArrayList<Card> cards) {
        for (Card card : cards) {
            if (card.getSuit() == Suits.hearts) {
                amountOfHeartsCollected++;
                System.out.println(getName() + " has collected the " + card.getFaceSymbol() + " of hearts");
            }
            if (card.getSuit() == Suits.spades && card.getFace() == FaceValue.QUEEN) {
                hasQueenOfSpade = true;
                System.out.println(getName() + " has also collected the Queen of Spades");
            }
        }
        System.out.println("------------------------------------------");
        System.out.println(getName() + " has collected " + amountOfHeartsCollected + " hearts");
        if (hasQueenOfSpade)
            System.out.println(getName() + " has also collected the Queen of Spades");
        System.out.println(getName() + " has " + findScore() + " points.");
        System.out.println("------------------------------------------");
    }

    public int findScore() {
        return hasQueenOfSpade ? 13 + amountOfHeartsCollected : amountOfHeartsCollected;
    }

    public void updateScores(int score) {
        scores.add(score);
    }

    public int totalScore() {
        return scores.stream().reduce(Integer::sum).orElse(0);
    }

    public List<Integer> getScores() {
        return scores;
    }
}
