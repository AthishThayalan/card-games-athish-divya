package org.example.Users;

import org.example.Deck.*;
import org.example.Game.Display;

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
        cardsInHand.sort(new SortBySuit());
    }

    public Card[] selectThreeCardsToBePassed() {
        Card[] cardsToBePassed = new Card[3];
        int[] indexes = new int[3];
        for (int i = 0; i < 3; i++) {
            var indexObject = new Object() {
                int index = 0;
            };
            do {
                System.out.println("Please choose card no " + (i + 1));
                indexObject.index = getInput();
            } while (Arrays.stream(indexes).anyMatch(x -> x == indexObject.index));
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
        System.out.println("──────────────");
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

    public Card selectOneCard(boolean isHeartBroken) {
        System.out.println("Cards in hand:");
        System.out.println("──────────────");
        printCards();
        System.out.println("Please choose a card to play");
        int cardToBePlayed = getInput();
        Card card = playCard(cardToBePlayed);
        if (!isHeartBroken && card.getSuit() == Suits.HEARTS && amountOfCardsInHand(Suits.HEARTS) != amountOfCardsInHand()) {
            System.out.println("Card cannot be selected as hearts have not been broken.");
            addCard(card);
            sortHand();
            card = selectOneCard(false);
        }
        return card;
    }

    public boolean hasTwoOfClubs() {
        for (Card card : cardsInHand) {
            if (card.equals(new Card(Suits.CLUBS, FaceValue.TWO)))
                return true;
        }
        return false;
    }

    public int findIndexOfTwoOfClub() {
        for (int i = 0; i < 13; i++) {
            Card card = cardsInHand.get(i);
            if (card.equals(new Card(Suits.CLUBS, FaceValue.TWO))) {
                return i + 1;
            }
        }
        return -1;
    }

    public boolean hasShotTheMoon() {
        return findScore() == 26;
    }

    public void addCardsToPile(ArrayList<Card> cards) {
        for (Card card : cards) {
            if (card.getSuit() == Suits.HEARTS) {
                amountOfHeartsCollected++;
                System.out.println(name + " has collected the " + card.getFaceSymbol() + " of hearts");
            }
            if (card.getSuit() == Suits.SPADES && card.getFace() == FaceValue.QUEEN) {
                hasQueenOfSpade = true;
                System.out.println(name + " has collected the Queen of Spades");
            }
        }
        System.out.println("------------------------------------------");
        System.out.print(name + " has collected " + amountOfHeartsCollected + " hearts");
        if (hasQueenOfSpade)
            System.out.print(" and the Queen of Spades");
        System.out.println(".\t" + name + " has " + findScore() + " points.");
    }

    public int amountOfCardsInHand(Suits suit) {
        return (int) cardsInHand.stream().filter(card -> card.getSuit() == suit).count();
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

    @Override
    public void printCards() {
        Display.displayCards(cardsInHand.toArray(new Card[0]), true);
    }
}
