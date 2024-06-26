package org.example.Users;

import org.example.Deck.Card;
import org.example.Game.Display;
import org.example.Scanner.UserInput;

import java.util.ArrayList;
import java.util.List;

public class User {
    protected String name;
    protected List<Card> cardsInHand;

    public User(String name) {
        this.name = name;
        cardsInHand = new ArrayList<>();
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

    public int getHandValue() {
        return 0;
    }

    public void printCards() {
        System.out.println(name + "'s cards:");
        Display.displayCards(cardsInHand.toArray(new Card[0]), false);
    }

    public int getInput() {
        return UserInput.readInt(amountOfCardsInHand());
    }

}
