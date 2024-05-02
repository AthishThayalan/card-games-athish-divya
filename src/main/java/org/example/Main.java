package org.example;

import org.example.Deck.*;
import org.example.Scanner.UserInput;
import org.example.Users.User;

import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();

        User user = new User("Divya");
        user.addCard(new Card(Suits.diamonds, FaceValue.FOUR));
        user.addCard(new Card(Suits.diamonds, FaceValue.FIVE));
        user.addCard(new Card(Suits.diamonds, FaceValue.SIX));
        user.addCard(new Card(Suits.diamonds, FaceValue.SEVEN));
        user.printCards();
        System.out.println("Removed: " + user.playCard(1));
        user.printCards();
        UserInput userInput = new UserInput();
        int userChoice = userInput.readInt(5);
        System.out.println();



    }

}
