package org.example;
import java.util.*;

public class CoinToss {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("How many times u wanna flip the coin");
        int times = input.nextInt();
        int flips;

        for (int i=0; i<times; i++) {
            flips = rand.nextInt(2)+1;
            if (flips == 1) {
                System.out.println("Heads");
            }
            else if (flips == 2) {
                System.out.println("Tails");
            }
        }

    }
}
