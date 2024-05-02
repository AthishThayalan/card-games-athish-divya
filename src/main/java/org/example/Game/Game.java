package org.example.Game;

import org.example.Deck.Deck;
import org.example.Users.User;

public abstract class Game {
    private Deck deckOfCards;
    private User[] users;

    public Game(User user) {
        this.deckOfCards = new Deck();
        this.users = new User[2];
        this.users[0] = user;
    }

    public abstract void resetGame();
    public abstract void play();
    public abstract boolean gameOngoing();
    public abstract boolean gameWon();
    public abstract boolean gameLost();

}
