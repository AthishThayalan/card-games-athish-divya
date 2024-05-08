package org.example.Game;

import org.example.Deck.Card;
import org.example.Users.Computer;
import org.example.Users.User;

import java.util.List;

public class BlackjackDisplay {
    public String drawFlippedCard() {
        StringBuilder builder = new StringBuilder();
        builder.append("┌─────────┐\n");
        builder.append("│#########│\n".repeat(5));
        builder.append("└─────────┘\n");
        return builder.toString();
    }

    public void printUsersAndCards(User[] players, boolean userStands) {
        for (User player : players) {
            System.out.println(player.getName() + "'s cards:");
            System.out.println("*".repeat(20));
            if (player instanceof Computer) {
                List<Card> cards = player.getCardsInHand();
                System.out.println(cards.get(0));
                if (userStands) {
                    for (int i = 1; i < cards.size(); i++) {
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
}

