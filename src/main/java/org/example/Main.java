package org.example;

import org.example.Deck.*;
import org.example.Game.Blackjack;
import org.example.Scanner.UserInput;
import org.example.Users.User;

import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Blackjack blackjack = new Blackjack(new User("Athish"));
        blackjack.dealInitialCards();
        blackjack.printUsersAndCards();



    }

}
