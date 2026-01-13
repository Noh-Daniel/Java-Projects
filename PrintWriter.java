package org.example;

import java.io.*;
import java.util.*;

public class PrintWriter {
    public static void main(String[] args) throws IOException {
        java.io.PrintWriter writer = new java.io.PrintWriter(new File("RandNums.txt"));
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("How many random numbers from 1-100 do you wanna add?");
        int num = input.nextInt();
        int count = 0;

        for (int i=0; i<num; i++){
            int randomInt = rand.nextInt(100)+1;

        }
        writer.close();
    }
}


