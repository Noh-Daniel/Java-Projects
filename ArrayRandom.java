package org.example;
import java.util.*;

public class ArrayRandom {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 50; i++) {
            numbers.add(rand.nextInt(100) + 1); // 1 to 100 inclusive
        }

        System.out.println("Original ArrayList:");
        System.out.println(numbers);

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number between 1 and 10: ");
        int userNum = input.nextInt();

        numbers.removeIf(n -> n % userNum == 0);

        System.out.println("Updated ArrayList (numbers not divisible by " + userNum + "):");
        System.out.println(numbers);
    }
}

