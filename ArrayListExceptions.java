package org.example;

import java.util.*;


public class ArrayListExceptions {
    public static void main(String[] args) {
        ArrayList<Integer> randomNums = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 50; i++) {
            randomNums.add(rand.nextInt(10));
        }

        System.out.println("Random numbers: " + randomNums);

        Scanner input = new Scanner(System.in);
        int userNum = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter a number between 1 and 10: ");
                userNum = input.nextInt();
                if (userNum < 1 || userNum > 10) {
                    System.out.println("Number must be between 1 and 10.");
                } else {
                    validInput = true;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                input.nextLine();
            }
        }

        ArrayList<Double> results = new ArrayList<>();

        for (int i = 0; i < randomNums.size(); i++) {
            int num = randomNums.get(i);
            try {
                double result = (double) num / userNum;
                results.add(result);
            } catch (ArithmeticException e) {
                continue;
            }
        }

        System.out.println("Division results: " + results);
    }
}
