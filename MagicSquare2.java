package org.example;

import java.util.Scanner;

public class MagicSquare2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] square = new int[4][4];
        System.out.println("Enter 16 numbers:");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                square[i][j] = input.nextInt();
            }
        }

        int target = 0;
        for (int j = 0; j < 4; j++) {
            target += square[0][j];
        }

        boolean isMagic = true;

        for (int i = 0; i < 4; i++) {
            int rowSum = 0;
            for (int j = 0; j < 4; j++) {
                rowSum += square[i][j];
            }
            if (rowSum != target) isMagic = false;
        }

        for (int j = 0; j < 4; j++) {
            int colSum = 0;
            for (int i = 0; i < 4; i++) {
                colSum += square[i][j];
            }
            if (colSum != target) isMagic = false;
        }

        int diag1 = 0;
        for (int i = 0; i < 4; i++) {
            diag1 += square[i][i];
        }
        if (diag1 != target) isMagic = false;

        int diag2 = 0;
        for (int i = 0; i < 4; i++) {
            diag2 += square[i][3 - i];
        }
        if (diag2 != target) isMagic = false;

        if (isMagic) {
            System.out.println("Magic square, constant = " + target);
        }

        else {
            System.out.println("Not a magic square.");
        }
    }
}
