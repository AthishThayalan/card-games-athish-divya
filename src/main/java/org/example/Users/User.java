package org.example.Users;

import org.example.Deck.Card;
import org.example.Deck.FaceValue;
import org.example.Deck.Suits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private String name;
    private List<Card> cardsInHand;

    public User(String name) {
        this.name = name;
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

    public Card removeCard(Card card) {
        for (int i=0; i<cardsInHand.size();i++){
            if(cardsInHand.get(i).equals(card))
                return cardsInHand.remove(i);
        }
        System.out.println("Sorry, the card you have chosen is not in your hand! Please choose a different one.");
        return null;
    }


}
