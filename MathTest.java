package org.example;
import java.util.*;

public class MathTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        double number1 = input.nextInt();
        System.out.println("Enter a number: ");
        double number2 = input.nextInt();

        if (number1<=0){
            System.out.println("Invalid number");
            System.exit(0);
        }
        else if (number2<=0){
            System.out.println("Invalid number");
            System.exit(0);
        }
        System.out.println(Math.max(number1, number2));
        System.out.println(Math.min(number1, number2));
        System.out.println(Math.pow(number1, number2));
        System.out.println(Math.sqrt(number1));
        System.out.println(Math.sqrt(number2));
    }
}
