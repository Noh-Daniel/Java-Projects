/*
Noh Daniel
Ms. Ogle
November 17th, 2025
Description: Asks the user for number of rows and columns, makes a 2D array with random numbers from 1-100, prints it in a table,
and lets the user do different things on the array using a menu until they choose to exit.
 */

import java.util.*;

public class A2Q2 {

    // Method that prints the main menu options
    private static void printMenu() {
        System.out.println("\nMenu");
        System.out.println("1 - Sum of entire array");
        System.out.println("2 - Average of entire array");
        System.out.println("3 - Maximum value in array");
        System.out.println("4 - Minimum value in array");
        System.out.println("5 - Sum of a row");
        System.out.println("6 - Sum of a column");
        System.out.println("7 - Count how many times a number appears");
        System.out.println("8 - Exit");
        System.out.print("Choose (1-8): ");
    }

    // Method that prints the 2D array in table form
    private static void printArray(int[][] array) {
        System.out.println("\n2D Array:");
        for (int i = 0; i < array.length; i++) { // Loops through rows
            for (int j = 0; j < array[i].length; j++) { // Loops through columns
                System.out.print(array[i][j] + "\t"); // "\t" is tab, used so it lines up in columns
            }
            System.out.println(); // Prints new line for next row
        }
    }

    // Method that gives the sum of the entire 2D array
    private static int sumArray(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) { // Loops through rows
            for (int j = 0; j < array[i].length; j++) { // through columns
                sum += array[i][j]; // Add each value to each other
            }
        }
        return sum; //  Give back the answer
    }

    // Method that gives the average of the entire 2D array
    private static double averageArray(int[][] array) {
        int sum = sumArray(array); // Can use the method made earlier to get the sum of the whole thing
        int totalElements = array.length * array[0].length; // Multiplies rows by columns to get toal number of elements
        return (double) sum / totalElements; // Divides sum by the total elements to get the average, double is used to get a decimal
    }

    // Method that gives the maximum value in the 2D array
    private static int maxArray(int[][] array) {
        int max = array[0][0]; // Start with first element
        for (int i = 0; i < array.length; i++) { // Loops through rows
            for (int j = 0; j < array[i].length; j++) { // Loops through columns
                if (array[i][j] > max) {
                    max = array[i][j]; // Gets max and updates it when a bigger number is found
                }
            }
        }
        return max; // Give back final max
    }

    // Method that gives the minimum value in the 2D array
    private static int minArray(int[][] array) {
        int min = array[0][0]; // Start with first element
        for (int i = 0; i < array.length; i++) { // Loops through rows
            for (int j = 0; j < array[i].length; j++) { // Loops through columns
                if (array[i][j] < min) {
                    min = array[i][j]; // Updates the min when a smaller number is found
                }
            }
        }
        return min; // Give back final min
    }

    // Gives the sum of all elements in a specific row
    private static int sumRow(int[][] array, int rowIndex) {
        int sum = 0;
        for (int j = 0; j < array[rowIndex].length; j++) { // Goes across that row
            sum += array[rowIndex][j]; // Adds up every element in row
        }
        return sum; // Gives back the sum
    }

    // Gives the sum of all elements in a specific column
    private static int sumColumn(int[][] array, int colIndex) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) { // Goes down the column
            sum += array[i][colIndex]; // Adds every number in the column
        }
        return sum; // Gives back the sum
    }

    // Counts how many times a number appears in the 2D array
    private static int countNumber(int[][] array, int target) {
        int count = 0; // Stores how many times target shows up
        for (int i = 0; i < array.length; i++) { // Loops through rows
            for (int j = 0; j < array[i].length; j++) { // Loops through columns
                if (array[i][j] == target) { // Checks if a specific element is the same as the target
                    count++; // If so, add 1 to the counter
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the 2D Array Program!");

        int rows = 0;
        int cols = 0;

        // Ask user for number of rows and columns
        while (true) {
            try {
                System.out.print("Enter number of rows (>0): ");
                rows = input.nextInt();

                System.out.print("Enter number of columns (>0): ");
                cols = input.nextInt();

                if (rows <= 0 || cols <= 0) { // Makes sure rows and columns are greater than 0
                    System.out.println("Rows and columns must both be greater than 0");
                } else {
                    break;
                }
            } catch (InputMismatchException e) { // Exception handling for user entering something other than an integer
                System.out.println("Invalid input, please enter whole numbers for rows and columns");
                input.nextLine(); // Clears said input
            }
        }

        // Makes the 2D array using the row and column sizes given
        int[][] array = new int[rows][cols];

        Random rand = new Random();

        // Fill the array with random numbers from 1-100
        for (int i = 0; i < rows; i++) { // Loops through rows
            for (int j = 0; j < cols; j++) { // Loops through columns
                array[i][j] = rand.nextInt(100) + 1; // Fills each element with random numbers from 1-100
            }
        }

        // Print the array in a table at the start using print array method
        printArray(array);

        boolean running = true; // Used to loop

        // Main menu loop that keeps going until user chooses option 8
        while (running) {

            printMenu(); // Main menu option using print menu method

            int choice = 0;

            // Exception handling for main menu choice
            try {
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number from 1 to 8.");
                input.nextLine(); // Gets rid of invalid input
                continue; // Goes back to top of loop
            }

            if (choice == 1) {
                // Sum of entire array
                int sum = sumArray(array);
                System.out.println("Sum of all elements in the array = " + sum);

            } else if (choice == 2) {
                // Average of entire array
                double avg = averageArray(array);
                System.out.println("Average of all elements in the array = " + avg);

            } else if (choice == 3) {
                // Maximum value
                int max = maxArray(array);
                System.out.println("Maximum value in the array = " + max);

            } else if (choice == 4) {
                // Minimum value
                int min = minArray(array);
                System.out.println("Minimum value in the array = " + min);

            } else if (choice == 5) {
                // Sum of a given row
                int rowChoice = 0;

                while (true) { // Keeps asking until valid row
                    try {
                        System.out.print("Enter row number (1 to " + rows + "): ");
                        rowChoice = input.nextInt();

                        if (rowChoice < 1 || rowChoice > rows) { // Checks that row choice is valid
                            System.out.println("Invalid row, please choose between 1 and " + rows);
                        } else {
                            break;
                        }
                    } catch (InputMismatchException e) { // Exception handling for if input isnt an integer
                        System.out.println("Invalid input. Enter a whole number for the row.");
                        input.nextLine(); // Gets rid of invalid input
                    }
                }

                int rowSum = sumRow(array, rowChoice - 1); // Takes user input and subtracts 1 to make it 0 based (since while we count 1,2,3... the computer starts from 0, so subtracting 1 from user input will give you the row they want
                System.out.println("Sum of row " + rowChoice + " = " + rowSum);

            } else if (choice == 6) {
                // Sum of a given column
                int colChoice = 0;

                while (true) { // Keeps asking until valid column
                    // All this is the same principle as the rows stuff you just read above but for columms this time
                    try {
                        System.out.print("Enter column number (1 to " + cols + "): ");
                        colChoice = input.nextInt();

                        if (colChoice < 1 || colChoice > cols) {
                            System.out.println("Invalid column. Please choose between 1 and " + cols + ".");
                        } else {
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Enter a whole number for the column.");
                        input.nextLine();
                    }
                }

                int colSum = sumColumn(array, colChoice - 1); // Takes user input and subtracts 1 to make it 0 based (since while we count 1,2,3... the computer starts from 0, so subtracting 1 from user input will give you the column they want
                System.out.println("Sum of column " + colChoice + " = " + colSum);

            } else if (choice == 7) {
                // Count how many times a number appears
                int target = 0;

                while (true) {
                    try {
                        System.out.print("Enter a number from 1 to 100 to search for: ");
                        target = input.nextInt();

                        if (target < 1 || target > 100) { // Checks the target is actually a number between 1-100
                            System.out.println("Number must be between 1 and 100.");
                        } else {
                            break;
                        }
                    } catch (InputMismatchException e) { // Exception handling for if the target is an actual integer
                        System.out.println("Invalid input. Enter a whole number between 1 and 100.");
                        input.nextLine(); // Gets rid of invalid input
                    }
                }

                int count = countNumber(array, target);
                System.out.println("The number " + target + " appears " + count + " time(s) in the array.");

            } else if (choice == 8) {
                // Exit
                System.out.println("Exiting program, bye!");
                running = false; // Ends the loop

            } else {
                System.out.println("Invalid choice, please pick a number between 1 and 8");
            }
        }
    }
}
