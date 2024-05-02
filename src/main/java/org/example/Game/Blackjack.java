package org.example.Game;

import org.example.Deck.Card;
import org.example.Deck.Deck;
import org.example.Deck.FaceValue;
import org.example.Deck.Suits;
import org.example.Users.Computer;
import org.example.Users.User;

public class Blackjack extends Game {
    private User[] players;

    public Blackjack(User[] users) {
        super(users);
        this.players = users;

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

    public int getPlayerHandTotal(User player){
        return  player.getHandValue();
    }

    public void dealInitialCards(){
        for(User player : players){
            for(int i =0;i<2;i++){
                Card dealtCard = deckOfCards.dealCard();
                assignCardValues(dealtCard,player);
                player.addCard(dealtCard);
            }
        }
    }

    public void dealInitialCardsForTest() {
        for (User player : players) {
            for (int i = 0; i < 3; i++) {
                Card aceCard = new Card(Suits.hearts, FaceValue.ACE);
                assignCardValues(aceCard,player);
                player.addCard(aceCard);
            }
        }
    }

    private void assignCardValues(Card card,User player){
        if (card.getFaceSymbol().equals("J") || card.getFaceSymbol().equals("Q") || card.getFaceSymbol().equals("K")) {
            card.setValue(10);
        }else if (card.getFaceSymbol().equals("A")) {
            int totalValue = getPlayerHandTotal(player);
            if (totalValue + 11 > 21) {
                card.setValue(1);
            } else {
                card.setValue(11);
            }

        }
    }

}
