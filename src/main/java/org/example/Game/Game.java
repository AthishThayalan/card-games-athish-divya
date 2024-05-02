package org.example.Game;

import org.example.Deck.Deck;
import org.example.Users.User;

public abstract class Game {
    protected Deck deckOfCards;
    protected User[] users;

    public Game(User[] users) {
        this.deckOfCards = new Deck();
        this.users = users;
    }

    public abstract void resetGame();

    public abstract void play();

    public abstract boolean gameOngoing();

    public abstract boolean gameWon();

    public abstract boolean gameLost();

}