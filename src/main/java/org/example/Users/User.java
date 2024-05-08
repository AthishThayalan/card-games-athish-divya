package org.example.Users;

import org.example.Deck.Card;
import org.example.Scanner.UserInput;

import java.util.ArrayList;
import java.util.List;

public class User {
    protected String name;
    protected List<Card> cardsInHand;
    protected UserInput userInput;

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

    public int getHandValue(){
        return 0;
    }

    public void printCards() {
        for (int i = 0; i < cardsInHand.size(); i++) {
            System.out.printf(cardsInHand.get(i).toString());
        }
    }

    public int getInput() {
        return userInput.readInt(amountOfCardsInHand());
    }

}
