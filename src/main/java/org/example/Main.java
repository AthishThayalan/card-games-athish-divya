package org.example;

import org.example.Game.Game;
import org.example.Game.HeartsGame;
import org.example.Game.Blackjack;
import org.example.Scanner.UserInput;
import org.example.Scanner.UserOptions;
import org.example.Users.HeartsComputerUser;
import org.example.Users.HeartsUser;
import org.example.Users.BlackjackUser;
import org.example.Users.Computer;
import org.example.Users.User;


public class Main {
    public static void main(String[] args) {

        UserOptions splashMenu = new UserOptions(new String[]{"BlackJack", "Hearts", "Exit Games"});
        UserOptions mainMenu = new UserOptions(new String[]{"Play a new Game", "Checkout the rules", "Go back"});
        int splashMenuOption = 0;
        int mainMenuOption;

        System.out.println("WELCOME TO THE GAMES!!!");
        System.out.println("========================");
        String name = UserInput.readName();

        while (splashMenuOption != 3) {
            splashMenuOption = splashMenu.getOption();
            switch (splashMenuOption) {
                case 1:
                    do {
                        mainMenuOption = mainMenu.getOption();
                        switch (mainMenuOption) {
                            case 1:
                                BlackjackUser user = new BlackjackUser(name);
                                Computer computer = new Computer();
                                User[] users = {user, computer};
                                Blackjack blackjack = new Blackjack(users);
                                blackjack.play();
                                break;
                            case 2:
                                System.out.println("Blackjack rules");
                                break;
                        }
                    } while (mainMenuOption == 2);
                    break;
                case 2:
                    do {
                        mainMenuOption = mainMenu.getOption();
                        switch (mainMenuOption) {
                            case 1:
                                HeartsUser player = new HeartsUser("Divya");
                                HeartsUser[] players = new HeartsUser[]{player, new HeartsComputerUser("CPU-1"), new HeartsComputerUser("CPU-2"), new HeartsComputerUser("CPU-3")};
                                Game hearts = new HeartsGame(players);
                                hearts.play();
                                break;
                            case 2:
                                System.out.println("Hearts rules");

                                break;
                        }
                    } while (mainMenuOption == 2);

            }
        }
    }
}
