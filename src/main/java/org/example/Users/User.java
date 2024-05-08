package org.example.Users;

import org.example.Deck.Card;
import org.example.Scanner.UserInput;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Card> cardsInHand;
    private UserInput userInput;

    public void setCardsInHand(List<Card> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }

    public User(String name) {
        this.name = name;
        this.userInput = new UserInput();
        cardsInHand = new ArrayList<Card>();
    }

    public List<Card> getCardsInHand() {
        return cardsInHand;
    }

    public String getName() {
        return name;
    }

    public void addCard(Card card) {
        cardsInHand.add(card);
    }

    public int amountOfCardsInHand() {
        return cardsInHand.size();
    }

    public Card playCard(int n) {
        return cardsInHand.remove(n - 1);

    }

    public void printCards() {
        for (int i = 0; i < cardsInHand.size(); i++) {
            System.out.println((i + 1) + ".)  " + cardsInHand.get(i).toString());
        }
    }

    public int getInput() {
        return userInput.readInt(amountOfCardsInHand());
    }

    public boolean hasTwoOfClubs() {
        return false;
    }

    public Card[] selectThreeCardsToBePassed() {
        return null;
    }

    public void updateScores(int score) {
    }

    public int totalScore() {
        return 0;
    }

    public boolean hasShotTheMoon() {
        return false;
    }

    public void addCardToPile(ArrayList<Card> cards) {
    }

    public List<Integer> getScores() {
        return null;
    }

    public void addThreeCards(Card[] cards) {
    }

    public Card selectOneCard(ArrayList<Card> cards) {
        return null;
    }

    public Card selectOneCard(boolean isHeartBroken) {
        return null;
    }

    public int findScore() {
        return 0;
    }

    public void sortHand() {
    }

}
