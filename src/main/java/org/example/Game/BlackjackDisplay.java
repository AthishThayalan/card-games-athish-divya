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

    public void printRules(){
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                        RULES OF BLACKJACK                                    ║");
        System.out.println("║                                                                              ║");
        System.out.println("║  1. Aim: The goal is to beat the dealer without going over 21.               ║");
        System.out.println("║                                                                              ║");
        System.out.println("║  2. Cards: Numbered cards are worth their face value,                        ║");
        System.out.println("║            face cards (Jacks, Queens, Kings) are worth 10, and Aces can be   ║");
        System.out.println("║            worth 1 or 11.                                                    ║");
        System.out.println("║                                                                              ║");
        System.out.println("║  3. Dealing: The dealer gives each player (including themselves) two         ║");
        System.out.println("║              cards. One of the dealer's cards is dealt face up, the other    ║");
        System.out.println("║              face down.                                                      ║");
        System.out.println("║                                                                              ║");
        System.out.println("║  4. Player's Turn: Players decide whether to \"hit\" (take another card)       ║");
        System.out.println("║                     or \"stand\" (keep their current hand).                    ║");
        System.out.println("║                                                                              ║");
        System.out.println("║  5. Dealer's Turn: Once the player \"stands\" have acted, the dealer reveals   ║");
        System.out.println("║                     their face-down card. They must hit until their hand     ║");
        System.out.println("║                     reaches 17 or higher.                                    ║");
        System.out.println("║                                                                              ║");
        System.out.println("║  6. Winning: Players win if they have a hand closer to 21 than the           ║");
        System.out.println("║              dealer's without going over. If the player's hand exceeds 21,   ║");
        System.out.println("║              they \"bust\" and lose. If the dealer busts, the player wins.     ║");
        System.out.println("║                                                                              ║");
        System.out.println("║  7. Blackjack: If a player's first two cards are an Ace and a                ║");
        System.out.println("║                10-value card (10, J, Q, K), they have a \"Blackjack\" and      ║");
        System.out.println("║                usually win 1.5 times their bet.                              ║");
        System.out.println("║                                                                              ║");
        System.out.println("║                                                                              ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════╝");

    }

    public void blackjackDisplayMessage(){
        String asciiArt =
                " _     _            _    _            _    \n" +
                        "| |   | |          | |  (_)          | |   \n" +
                        "| |__ | | __ _  ___| | ___  __ _  ___| | __\n" +
                        "| '_ \\| |/ _` |/ __| |/ / |/ _` |/ __| |/ /\n" +
                        "| |_) | | (_| | (__|   <| | (_| | (__|   < \n" +
                        "|_.__/|_|\\__,_|\\___|_|\\_\\ |\\__,_|\\___|_|\\_\\\n" +
                        "                       _/ |                \n" +
                        "                      |__/                 \n";
        System.out.println(asciiArt);

    }
}

