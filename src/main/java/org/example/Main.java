package org.example;

import org.example.Deck.*;
import org.example.Game.Game;
import org.example.Game.HeartsGame;
import org.example.Game.Blackjack;
import org.example.Scanner.UserInput;
import org.example.Users.HeartsComputerUser;
import org.example.Users.HeartsUser;
import org.example.Users.BlackjackUser;
import org.example.Users.Computer;
import org.example.Users.User;

import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BlackjackUser user = new BlackjackUser("Athish");
        Computer computer = new Computer();
        User[] users = {user,computer};
        Blackjack blackjack = new Blackjack(users);
        blackjack.play();
        Deck deck = new Deck();

        HeartsUser player = new HeartsUser("Divya");
        HeartsUser[] players = new HeartsUser[]{player, new HeartsComputerUser("CPU-1"), new HeartsComputerUser("CPU-2"), new HeartsComputerUser("CPU-3")};


        Game hearts = new HeartsGame(players);

        hearts.play();

    }

}
