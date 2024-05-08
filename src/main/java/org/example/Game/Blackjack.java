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
    private BlackjackDisplay blackjackDisplay;

    public Blackjack(User[] users) {
        this.userStands = false;
        this.players = users;
        this.blackjackDisplay = new BlackjackDisplay();

    }

    @Override
    public void resetGame() {

    }

    @Override
    public void play() {
        dealInitialCards();


        User computer = players[1];
        User player1 = players[0];

        if (checkForBlackjack(player1, computer)) {
            this.blackjackDisplay.printUsersAndCards(players, userStands);
            return;
        }
        outerLoop:
        while (gameOngoing()) {
            this.blackjackDisplay.printUsersAndCards(players, userStands);
            System.out.println("The value of your hand is: " + getPlayerHandTotal(player1));
            for (User player : players) {
                if (player instanceof Computer) {
                    while (getPlayerHandTotal(player) < 17) {
                        Card dealtCard = deckOfCards.dealCard();
                        assignCardValues(dealtCard, player);
                        player.addCard(dealtCard);
                        adjustAcesValue(player);
                        this.blackjackDisplay.printUsersAndCards(players, userStands);
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
                            this.blackjackDisplay.printUsersAndCards(players, userStands);
                            System.out.println("Player 1 value: " + player1.getHandValue());
                            System.out.println("CPU value: " + computer.getHandValue());
                            if (getPlayerHandTotal(player) > 21) {
                                System.out.println(player1.getName()+" has gone bust! Player 1's hand totalled:  " + getPlayerHandTotal(player));
                                computer.printCards();
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

            if (userChoseStand() || checkForBlackjack(player1, computer)) {
                this.blackjackDisplay.printUsersAndCards(players, userStands);
                int playerTotal = getPlayerHandTotal(player1);
                int computerTotal = getPlayerHandTotal(computer);

                if (playerTotal > 21) {
                    System.out.println("UNLUCKY YOU WENT BUST. DEALER WINS!");
                } else if (computerTotal > 21 || playerTotal > computerTotal) {
                    System.out.println("CONGRATULATIONS YOU BEAT THE DEALER!");
                } else if (playerTotal < computerTotal) {
                    System.out.println("Unlucky. The Dealers beat you this time :(");
                } else {
                    System.out.println("WOW! IT'S A TIE!");
                }
                System.out.println(player1.getName()+"'s value: " + getPlayerHandTotal(player1));
                System.out.println("Dealer Value: " + getPlayerHandTotal(computer));
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


    public boolean userChoseStand() {
        return this.userStands;
    }

    public int getPlayerHandTotal(User player) {
        return player.getHandValue();
    }

    public void dealInitialCards() {
        for (User player : players) {
            for (int i = 0; i < 2; i++) {
                Card dealtCard = deckOfCards.dealCard();
                assignCardValues(dealtCard, player);
                player.addCard(dealtCard);
                adjustAcesValue(player);

            }
        }
    }

    private boolean checkForBlackjack(User player1, User dealer) {
        if (getPlayerHandTotal(player1) == 21) {
            System.out.println(player1.getName() + " has blackjack! " + player1.getName() + " wins!");
            return true;
        } else if (getPlayerHandTotal(dealer) == 21) {
            System.out.println(dealer.getName() + " has blackjack! " + dealer.getName() + " wins!");
            dealer.printCards();
            return true;
        }
        return false;
    }


    public void adjustAcesValue(User player) {
        for (Card card : player.getCardsInHand()) {
            if (card.getFaceSymbol().equals("A")) {
                int handTotal = getPlayerHandTotal(player);
                if ((handTotal - card.getValue() + 11 > 21)) {
                    card.setValue(1);
                }
            }
        }
    }

    private void assignCardValues(Card card, User player) {
        if (card.getFaceSymbol().equals("J") || card.getFaceSymbol().equals("Q") || card.getFaceSymbol().equals("K")) {
            card.setValue(10);
        } else if (card.getFaceSymbol().equals("A")) {
            card.setValue(11);
        }

    }
}
