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
}
