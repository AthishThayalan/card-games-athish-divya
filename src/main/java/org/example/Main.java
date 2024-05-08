package org.example;

import org.example.Deck.*;
import org.example.Game.Game;
import org.example.Game.HeartsGame;
import org.example.Scanner.UserInput;
import org.example.Users.HeartsComputerUser;
import org.example.Users.HeartsUser;
import org.example.Users.User;

import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();

        HeartsUser user = new HeartsUser("Divya");
        HeartsUser[] users = new HeartsUser[]{user, new HeartsComputerUser("CPU-1"), new HeartsComputerUser("CPU-2"), new HeartsComputerUser("CPU-3")};


        Game hearts = new HeartsGame(users);

        hearts.play();

    }

}
