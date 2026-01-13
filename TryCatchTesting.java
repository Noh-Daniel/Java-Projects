package org.example;
import java.util.*;

public class TryCatchTesting {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int num = 0;
        boolean x = false;

        while (x =! false){
            System.out.print("Enter an integer: ");
            try {
                num = input.nextInt();
                System.out.println("Yuh");
                x = true;
            }
            catch(Exception e){
                System.out.println("Not an integer");
                input.nextLine();
            }

        }
    }
}