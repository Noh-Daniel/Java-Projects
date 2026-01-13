package org.example;

import java.util.*;

public class AreaRecPerimeter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Length of the rectangle: ");
        double length = input.nextDouble();

        System.out.print("Width of the rectangle: ");
        double width = input.nextDouble();

        if (length <= 0 || width <= 0) {
            System.out.println("Invalid input, Length and width must be above zero.");
            System.exit(0);
        }

        double area = length * width;
        double perimeter = 2 * (length + width);

        System.out.println("Area of the rectangle: " + area);
        System.out.println("Perimeter of the rectangle: " + perimeter);
    }
}
