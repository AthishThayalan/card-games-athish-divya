package org.example;

import org.example.Game.*;
import org.example.Scanner.UserInput;
import org.example.Scanner.UserOptions;
import org.example.Sleep.SleepUtils;

public class Main {
    public static void main(String[] args) {

        UserOptions splashMenu = new UserOptions(new String[]{"BlackJack", "Hearts", "Exit Games"});
        UserOptions mainMenu = new UserOptions(new String[]{"Play a new Game", "Checkout the rules", "Go back"});

        int splashMenuOption = 0;
        int mainMenuOption;

        System.out.println("WELCOME TO THE GAMES!!!");
        System.out.println("========================");
        String name = UserInput.readName();

        RunGame runGame = new RunGame();

        while (splashMenuOption != 3) {
            splashMenuOption = splashMenu.getOption();
            BlackjackDisplay blackjackDisplay = new BlackjackDisplay();
            switch (splashMenuOption) {
                case 1:
                    do {
                        mainMenuOption = mainMenu.getOption();
                        switch (mainMenuOption) {
                            case 1:
                                runGame.runBlackjack(name);
                                break;
                            case 2:
                                System.out.println("Loading rules...");
                                SleepUtils.sleep(2000);
                                blackjackDisplay.printRules();
                                break;
                        }
                    } while (mainMenuOption == 2);
                    break;
                case 2:
                    do {
                        mainMenuOption = mainMenu.getOption();
                        switch (mainMenuOption) {
                            case 1:
                                runGame.runHearts(name);
                                break;
                            case 2:
                                System.out.println("Hearts rules");
                                break;
                        }
                    } while (mainMenuOption == 2);
            }
        }
        System.out.println("Exiting...");
        SleepUtils.sleep(1000);

    }
}
