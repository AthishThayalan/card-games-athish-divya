package org.example.Game;

import org.example.Deck.Card;

public class Display {

    public static void displayCards(Card[] cards, boolean areCardsNumbered) {
        String[] cardArr = {"┌─────────┐", String.format("│ %-8s│", "#"), "│         │", String.format("│    %s    │", "*"), "│         │", String.format("│%8s │", "#"), "└─────────┘"};
        int amountOfCards = 5;
        Card[] cardsInARow = new Card[amountOfCards];
        for (int i = 0; i < cards.length; ) {
            for (int j = 0; j < amountOfCards; j++) {
                cardsInARow[j] = cards[i];
                i++;
                if (i == cards.length) {
                    amountOfCards = j + 1;
                }
            }
            if (areCardsNumbered) {
                for (int j = 0; j < amountOfCards; j++) {
                    int cardNo = i - amountOfCards + j + 1;
                    if (cardNo < 10)
                        System.out.print(" Card No: " + cardNo + " ");
                    else
                        System.out.print(" Card No:" + cardNo + " ");
                }
            }
            System.out.println();
            for (String line : cardArr) {
                String lineToBePrinted;
                for (int j = 0; j < amountOfCards; j++) {
                    if (line.contains("#")) {
                        lineToBePrinted = line.replace("#", cardsInARow[j].getFaceSymbol());
                        if (lineToBePrinted.contains("10"))
                            lineToBePrinted = lineToBePrinted.replace(" 10", "10");
                    } else if (line.contains("*"))
                        lineToBePrinted = line.replace("*", cardsInARow[j].getSuitSymbol());
                    else
                        lineToBePrinted = line;
                    System.out.print(lineToBePrinted);
                    System.out.print("\t");
                }
                System.out.println();
            }
        }
    }

}
