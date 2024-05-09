package org.example.Game;

public class HeartsDisplay {
    public static void printRules() {
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                           HEARTS RULES!!!                                    ║");
        System.out.println("║                                                                              ║");
        System.out.println("║  1. Aim: The object is to avoid scoring points.                              ║");
        System.out.println("║                                                                              ║");
        System.out.println("║  2. Cards: Each heart - 1 point                                              ║");
        System.out.println("║            The Q of Spade - 13 points                                        ║");
        System.out.println("║                                                                              ║");
        System.out.println("║  3. Dealing: Each player is dealt 13 cards                                   ║");
        System.out.println("║                                                                              ║");
        System.out.println("║  4. Passing the cards: Pass three cards as follows to your left in the first ║");
        System.out.println("║                        round, to your right in the second round and across   ║");
        System.out.println("║                        in the third round. Cards are not passed in the fourth║");
        System.out.println("║                        round. And then the cycle repeats.                    ║");
        System.out.println("║                                                                              ║");
        System.out.println("║  5. Trick: The person with the 2♣ must lead with it in the first trick.      ║");
        System.out.println("║            Players must each play a card of lead suit(if possible).          ║");
        System.out.println("║            A trick cannot be lead with hearts until hearts have been broken. ║");
        System.out.println("║                                                                              ║");
        System.out.println("║  6. Taking a trick: The person who played the highest card of the lead suit  ║");
        System.out.println("║                     takes the trick and leads to the next trick.             ║");
        System.out.println("║                                                                              ║");
        System.out.println("║  7. Shooting the moon: When a player collects all 13 heart cards and the Q   ║");
        System.out.println("║                        of Spades, the player gets 0 points while everyone    ║");
        System.out.println("║                        else gets 26 points.                                  ║");
        System.out.println("║                                                                              ║");
        System.out.println("║  8. Winning: The game ends when a player reaches 30 points.                  ║");
        System.out.println("║              The winner is the player with the lowest score at this point.   ║");
        System.out.println("║                                                                              ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════╝");

    }
}
