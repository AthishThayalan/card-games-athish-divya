package org.example.Game;

import org.example.Deck.Card;
import org.example.Deck.Deck;
import org.example.Deck.FaceValue;
import org.example.Deck.Suits;
import org.example.Scanner.UserInput;
import org.example.Users.Computer;
import org.example.Users.User;

import java.util.List;

public class Blackjack extends Game {
    private User[] players;
    private boolean userStands;

    public Blackjack(User[] users) {
        super(users);
        this.userStands = false;
        this.players = users;
        dealInitialCards();
    }

    @Override
    public void resetGame() {

    }

    @Override
    public void play() {
        User computer = users[1];
        User player1 = users[0];
        outerLoop:
        while (gameOngoing()) {
            printUsersAndCards();
            System.out.println("The value of your hand is: "+getPlayerHandTotal(player1));
            for (User player : players) {
                if (player instanceof Computer) {
                    while (getPlayerHandTotal(player) < 17) {
                        Card dealtCard = deckOfCards.dealCard();
                        assignCardValues(dealtCard, player);
                        player.addCard(dealtCard);
                        adjustAcesValue(computer);
                        printUsersAndCards();
                    }
                } else {
                    System.out.println(player.getName() + ", do you want to (1) Hit or (2) Stand?");
                    int choice;
                    do {
                        choice = UserInput.readInt(2);
                        if (choice == 1) {
                            Card dealtCard = deckOfCards.dealCard();
                            assignCardValues(dealtCard, player);
                            player.addCard(dealtCard);
                            adjustAcesValue(player1);
                            printUsersAndCards();
                            System.out.println("Player 1 value: " + player1.getHandValue());
                            System.out.println("CPU value: " + computer.getHandValue());
                            if (getPlayerHandTotal(player) > 21) {
                                System.out.println("Player 1 has gone bust! Player 1's hand totalled:  " + getPlayerHandTotal(player));
                                break outerLoop;
                            } else if (getPlayerHandTotal(player) == 21) {
                                System.out.println("YOU WIN! YOU GOT 21!!!");
                                break outerLoop;
                            }
                        } else if (choice == 2) {
                            System.out.println("STAND");
                            userStands = true;
                            break;
                        }
                    } while (choice == 1 && gameOngoing());
                }
            }

            if (userChoseStand()) {
                printUsersAndCards();
                int playerTotal = getPlayerHandTotal(player1);
                int computerTotal = getPlayerHandTotal(computer);

                if (playerTotal > 21) {
                    System.out.println("UNLUCKY YOU WENT BUST. DEALER WINS!");
                } else if (computerTotal > 21 || playerTotal > computerTotal) {
                    System.out.println("YOU WIN!!");
                } else if (playerTotal < computerTotal) {
                    System.out.println("DEALER WINS!");
                } else {
                    System.out.println("It's a tie! WOOHOOO");
                }
                System.out.println("Player value : "+getPlayerHandTotal(player1));
                System.out.println("Dealer Value: "+getPlayerHandTotal(computer));
                break;

            }

        }
    }



    @Override
    public boolean gameOngoing() {
        for (User player : players) {
            if (getPlayerHandTotal(player) > 21) {
                return false;
            }
        }
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

    public boolean userChoseStand(){
        return this.userStands;
    }

    public  String drawFlippedCard() {
        StringBuilder builder = new StringBuilder();
        // ASCII representations for each card
        builder.append("┌──────────┐\n");
        for (int i = 0; i < 8; i++) {
            builder.append("│##########│\n");
        }
        builder.append("└──────────┘\n");
        return builder.toString();
    }

    public void printUsersAndCards() {
        for (User player : players) {
            System.out.println(player.getName() + "'s cards:");
            if (player instanceof Computer) {
                List<Card> cards = player.getCardsInHand();
                System.out.println(cards.get(0));
                if(userChoseStand()){
                    for(int i = 1;i<cards.size();i++){
                        System.out.println(cards.get(i));
                    }

                } else {
                    System.out.println(drawFlippedCard());
                }

            } else {
                player.printCards();
            }
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
                adjustAcesValue(player);
            }
        }
    }



    // Created a seperate method so if In the inital dealing of the 2 cards and ACE was dealt , it always loops through the cards and dynamically changes A from 1 to 11 if possible
    public void adjustAcesValue(User player) {
        for(Card card : player.getCardsInHand()){
            if(card.getFaceSymbol().equals("A")){
                if(getPlayerHandTotal(player) + 11 < 21){
                    card.setValue(11);
                }
            }
        }
    }

    private void assignCardValues(Card card, User player) {
        if (card.getFaceSymbol().equals("J") || card.getFaceSymbol().equals("Q") || card.getFaceSymbol().equals("K")) {
            card.setValue(10);
        } else if (card.getFaceSymbol().equals("A")) {
            card.setValue(1);
        }

    }

}
