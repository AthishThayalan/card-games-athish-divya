package org.example.Game;

import org.example.Deck.Deck;
import org.example.Users.User;

public abstract class Game {
    private Deck deckOfCards;

    public Game(User[] users) {
        this.deckOfCards = new Deck();
    }

    public abstract void resetGame();

    public abstract void play();

    public abstract boolean gameOngoing();


}