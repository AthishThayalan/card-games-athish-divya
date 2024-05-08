package org.example.Scanner;

public class UserOptions extends UserInput {
    public String[] options;

    public UserOptions(String[] options) {
        this.options = options;
    }

    public int getOption() {
        System.out.println("Please choose one of the following option:");
        printUserOptions(options);
        int optionNum = 0;
        while (optionNum == 0) {
            optionNum = readInt(options.length);
        }
        return optionNum;
    }

    public void printUserOptions(String[] userOptions) {
        for (int i = 0; i < userOptions.length; i++) {
            System.out.println("Option " + (i + 1) + ": " + userOptions[i]);
        }
    }
}