/*
Noh Daniel
Ms. Ogle
A1Q2 - Mini Calculator
ICS4U1
*/

import java.util.*;

public class A1Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String cont; // Variable for later, will use to store if user wants to quit

        do {
            // Ask user for two integers
            System.out.print("First integer: ");
            double num1 = input.nextInt();
            System.out.print("Second integer: ");
            double num2 = input.nextInt();

            // Ask for an operation (+, -, /, *, ^)
            String operation; // Variable to hold the operation, I declared it outside the loop so I can use it later
            while (true) { // While loop that will loop until valid operation is entered
                System.out.print("Enter an operation (+, -, x, /, ^): ");
                operation = input.next();

                if (operation.equals("+") || operation.equals("-") ||
                        operation.equals("x") || operation.equals("/") ||
                        operation.equals("^")) {
                    break; // User entered a valid operation
                } else {
                    System.out.println("Invalid input, only enter +, -, x, /, or ^."); // Loops until invalid input is entered
                }
            }

            switch (operation) {
                case "+":
                    System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
                    break;
                case "-":
                    System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
                    break;
                case "x":
                    System.out.println(num1 + " x " + num2 + " = " + (num1 * num2));
                    break;
                case "/":
                    if (num2 != 0) {
                        System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
                    } else {
                        System.out.println("Division by zero is not possible.");
                    }
                    break;
                case "^":
                    System.out.println(num1 + " ^ " + num2 + " = " + Math.pow(num1, num2));
                    break;
            }

            // ask to continue or quit
            System.out.print("Press anything to continue or q to quit: ");
            cont = input.next();

        } while (!cont.equals("q")); // repeats until user enters 'q'

        System.out.println("Calculator over, have a good day!");
    }
} // End of code
