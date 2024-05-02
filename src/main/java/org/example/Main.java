package org.example;

import org.example.Deck.*;
import org.example.Game.Blackjack;
import org.example.Scanner.UserInput;
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
        blackjack.dealInitialCards();
        blackjack.printUsersAndCards();

        System.out.println(blackjack.getPlayerHandTotal(user));


    }

}
