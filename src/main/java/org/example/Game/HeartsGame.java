package org.example.Game;

import org.example.Users.User;

public class HeartsGame extends Game{


    public HeartsGame(User user) {
        super(user);
    }

    @Override
    public void resetGame() {

    }

    @Override
    public void play() {

    }

    @Override
    public boolean gameOngoing() {
        return false;
    }

    @Override
    public boolean gameWon() {
        return false;
    }

    @Override
    public boolean gameLost() {
        return false;
    }
}
