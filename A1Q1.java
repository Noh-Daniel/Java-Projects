package org.example;
/*
Noh Daniel
Ms. Ogle
A1Q1 - Dice Roller
ICS4U1
*/

import java.util.*;

public class A1Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // So I can get input
        Random random = new Random();  // So I can generate random numbers

        System.out.println("Welcome to the digital dice roller!");

        while (true) { // The main loop, repeats until user enters 'n'
            int rounds = 0;

            // Ask for number of rounds (1–5)
            System.out.print("How many rounds would you like to roll the dice (1-5)? ");
            rounds = input.nextInt();

            // Check for invalid  input
            if (rounds < 1 || rounds > 5) {
                System.out.println("Invalid input, enter a number from 1-5.");
                continue; // Restart
            }

            // Use switch statement for number of rounds
            switch (rounds) {
                case 1:
                    for (int i = 1; i <= 1; i++) {
                        int dice1 = random.nextInt(6) + 1;
                        int dice2 = random.nextInt(6) + 1;
                        int sum = dice1 + dice2;
                        System.out.println("Roll " + i + ":");
                        System.out.println("Dice 1: " + dice1);
                        System.out.println("Dice 2: " + dice2);
                        System.out.println("Sum: " + sum);
                        System.out.println();
                    }
                    break;
                case 2:
                    for (int i = 1; i <= 2; i++) {
                        int dice1 = random.nextInt(6) + 1;
                        int dice2 = random.nextInt(6) + 1;
                        int sum = dice1 + dice2;
                        System.out.println("Roll " + i + ":");
                        System.out.println("Dice 1: " + dice1);
                        System.out.println("Dice 2: " + dice2);
                        System.out.println("Sum: " + sum);
                        System.out.println();
                    }
                    break;
                case 3:
                    for (int i = 1; i <= 3; i++) {
                        int dice1 = random.nextInt(6) + 1;
                        int dice2 = random.nextInt(6) + 1;
                        int sum = dice1 + dice2;
                        System.out.println("Roll " + i + ":");
                        System.out.println("Dice 1: " + dice1);
                        System.out.println("Dice 2: " + dice2);
                        System.out.println("Sum: " + sum);
                        System.out.println();
                    }
                    break;
                case 4:
                    for (int i = 1; i <= 4; i++) {
                        int dice1 = random.nextInt(6) + 1;
                        int dice2 = random.nextInt(6) + 1;
                        int sum = dice1 + dice2;
                        System.out.println("Roll " + i + ":");
                        System.out.println("Dice 1: " + dice1);
                        System.out.println("Dice 2: " + dice2);
                        System.out.println("Sum: " + sum);
                        System.out.println();
                    }
                    break;
                case 5:
                    for (int i = 1; i <= 5; i++) {
                        int dice1 = random.nextInt(6) + 1;
                        int dice2 = random.nextInt(6) + 1;
                        int sum = dice1 + dice2;
                        System.out.println("Roll " + i + ":");
                        System.out.println("Dice 1: " + dice1);
                        System.out.println("Dice 2: " + dice2);
                        System.out.println("Sum: " + sum);
                        System.out.println();
                    }
                    break;
            }

            // Ask the user if they want to roll again
            System.out.print("Do you want to roll again? (y for yes, n for no): ");
            String playAgain = input.next();

            // Checks if the input is 'n', ends game if it is
            if (playAgain.equals("n")) {
                System.out.println("Thanks for playing!");
                break;
            }
            // Checks if the input is 'y', loops game again if it is
            else if (playAgain.equals("y")) {
                continue;
            }
            // If input is not y or n, it's an invalid input
            else {
                // Invalid input for y/n
                System.out.println("Invalid input, enter 'y' for yes or 'n' for no.");
                // Loop to keep asking if user wants to continue until given a valid answer
                while (true) {
                    System.out.print("Do you want to roll again? (y for yes, n for no): ");
                    playAgain = input.next();

                    // If input is n, end game
                    if (playAgain.equals("n")) {
                        System.out.println("Thanks for playing!");
                        System.exit(0);
                    }
                    // If input is y, break this loop and go back to the beginning of the first loop
                    else if (playAgain.equals("y")) {
                        break;
                    }
                    // Invalid input, loops until valid
                    else {
                        System.out.println("Invalid input, enter 'y' for yes or 'n' for no.");
                    }
                }
            }
        }
    }
} // End of code
