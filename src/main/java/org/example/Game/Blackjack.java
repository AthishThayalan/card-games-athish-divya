package org.example.Game;

import org.example.Deck.Card;
import org.example.Deck.Deck;
import org.example.Users.Computer;
import org.example.Users.User;

public class Blackjack extends Game {

    private User[] players = new User[2];


//    public Blackjack(User user) {
//        super(user);
//        players[0] = user;
//        Computer dealer = new Computer();
//        players[1] = dealer;
//    }

    public Blackjack(User player) {
        super(new User[]{player, new Computer()});
        this.players[0] = player;
    }

    @Override
    public void resetGame() {

    }

    @Override
    public void play() {

    }

    @Override
    public boolean gameOngoing() {
        return true;
    }

    @Override
    public boolean gameWon() {
        return false;
    }

    @Override
    public boolean gameLost() {
        return false;
    }

    public void printUsersAndCards() {
        for (User player : players) {
            System.out.println(player.getName() + "'s cards:");
            player.printCards();
            System.out.println();
        }
    }

    public void dealInitialCards(){
        for(User player : players){
            for(int i =0;i<2;i++){
                Card dealtCard = deckOfCards.dealCard();
                player.addCard(dealtCard);
            }

        }
    }

    private void assignCardValues(Card card){
        if (card.getFaceSymbol().equals("J") || card.getFaceSymbol().equals("Q") || card.getFaceSymbol().equals("K")) {
            card.setValue(10);
        }else if (card.getFaceSymbol().equals("A")) {
            card.setValue(1);
        }
    }

}
