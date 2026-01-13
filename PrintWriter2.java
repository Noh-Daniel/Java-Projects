package org.example;

import java.io.*;
import java.util.*;

public class PrintWriter2 {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(new File("hello.txt"));

        int count = 0;
        String concat = "";
        while (reader.hasNext()) {
            concat = concat + reader.nextLine() + "\n";
            count++;
        }
        System.out.println("There are " + count + " \"hello\"s in the file");
        System.out.println(concat);


    }
}


