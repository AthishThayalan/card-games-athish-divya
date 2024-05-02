package org.example.Users;

import org.example.Deck.Card;
import org.example.Deck.FaceValue;
import org.example.Deck.Suits;
import org.example.Scanner.UserInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class User {
    private String name;
    private List<Card> cardsInHand;
    private UserInput userInput;

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

    public int amountofCardsInHand() {
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
            System.out.println((i + 1) + ".)\n" + cardsInHand.get(i).toString());
        }
    }


}
