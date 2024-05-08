package org.example.Scanner;

import java.util.Scanner;

public class UserInput {
    private final static Scanner scanner = new Scanner(System.in);

    public static int readInt(int max){
        int choice = -1;
        do {
            System.out.printf("Enter a number(1-%d) : ",max);
            try{
                choice = scanner.nextInt();
            } catch(Exception e ){
                System.out.println("Error : NaN");
                scanner.next();
            }

        }while(choice > max || choice < 1);
        return choice;
    }

    public static double readDouble() {
        double value = 0;
        boolean validInput = false;
        do {
            System.out.print("Enter a decimal number: ");
            try {
                value = scanner.nextDouble();
                if (value >= 1) {
                    validInput = true;
                } else {
                    System.out.println("Error: Value must be greater than or equal to 1.");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please enter a decimal number.");
                scanner.next();
            }
        } while (!validInput);
        return value;
    }
}
