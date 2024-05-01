package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.printDeck();
        System.out.println("size: "+deck.getDeckSize());
        deck.dealCard();
        System.out.println("_________________________");
        deck.printDeck();
        System.out.println("size: "+deck.getDeckSize());
        }
    }
