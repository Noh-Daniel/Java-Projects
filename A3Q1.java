/*
Noh Daniel
January 18th, 2026
A3Q1
Reads scarlet.txt, stores every line in it in an ArrayList, then counts how often every letter pops up (not case sensitive).
Then it writes frequencies of every letter, the top 5 most frequent, and the bottom 5 least frequent in frequencies.txt.
*/

import java.io.*;
import java.util.*;

public class A3Q1 {

    // method that reads the file then puts every line in an array list
    public static ArrayList<String> readFileLines(String fileName) throws IOException {
        ArrayList<String> lines = new ArrayList<>(); // Creates array list

        Scanner reader = new Scanner(new File(fileName));
        while (reader.hasNextLine()) { // Checks if there is another line
            lines.add(reader.nextLine()); // reads the whole line and adds it to the array list
        }
        reader.close(); // Closes file

        return lines; // gives the list of all lines from file
    }

    // Method that counts how many times every letter appears (not case sensitive)
    public static ArrayList<Integer> getLetterFrequencies(ArrayList<String> lines) {
        ArrayList<Integer> frequencies = new ArrayList<>();

        // Makes 26 slots in the array list and sets every one equal to 0
        for (int i = 0; i < 26; i++) {
            frequencies.add(0);
        }

        // Goes through every line
        for (String line : lines) { // Called an advanced for loop, recommended to me by my IDE when I wrote the normal for loop
            for (int j = 0; j < line.length(); j++) { // Checks every character
                char ch = line.charAt(j);

                if (Character.isLetter(ch)) { // Checks if there is a letter in the space using isLetter, so it skips spaces and numbers and stuff
                    ch = Character.toUpperCase(ch); // Since it is case insensitive, must make all letters either upper or lower case, I chose upper cause its easier to differentiate between certain things (like L vs 1)

                    switch (ch) { // Switch that checks if what letter it is, then adds 1 to the index of the arraylist its in.
                        case 'A': frequencies.set(0, frequencies.get(0) + 1); break;
                        case 'B': frequencies.set(1, frequencies.get(1) + 1); break;
                        case 'C': frequencies.set(2, frequencies.get(2) + 1); break;
                        case 'D': frequencies.set(3, frequencies.get(3) + 1); break;
                        case 'E': frequencies.set(4, frequencies.get(4) + 1); break;
                        case 'F': frequencies.set(5, frequencies.get(5) + 1); break;
                        case 'G': frequencies.set(6, frequencies.get(6) + 1); break;
                        case 'H': frequencies.set(7, frequencies.get(7) + 1); break;
                        case 'I': frequencies.set(8, frequencies.get(8) + 1); break;
                        case 'J': frequencies.set(9, frequencies.get(9) + 1); break;
                        case 'K': frequencies.set(10, frequencies.get(10) + 1); break;
                        case 'L': frequencies.set(11, frequencies.get(11) + 1); break;
                        case 'M': frequencies.set(12, frequencies.get(12) + 1); break;
                        case 'N': frequencies.set(13, frequencies.get(13) + 1); break;
                        case 'O': frequencies.set(14, frequencies.get(14) + 1); break;
                        case 'P': frequencies.set(15, frequencies.get(15) + 1); break;
                        case 'Q': frequencies.set(16, frequencies.get(16) + 1); break;
                        case 'R': frequencies.set(17, frequencies.get(17) + 1); break;
                        case 'S': frequencies.set(18, frequencies.get(18) + 1); break;
                        case 'T': frequencies.set(19, frequencies.get(19) + 1); break;
                        case 'U': frequencies.set(20, frequencies.get(20) + 1); break;
                        case 'V': frequencies.set(21, frequencies.get(21) + 1); break;
                        case 'W': frequencies.set(22, frequencies.get(22) + 1); break;
                        case 'X': frequencies.set(23, frequencies.get(23) + 1); break;
                        case 'Y': frequencies.set(24, frequencies.get(24) + 1); break;
                        case 'Z': frequencies.set(25, frequencies.get(25) + 1); break;
                    }
                }
            }
        }

        return frequencies;
    }

    // Method that takes list of frequencies for all the letters and return a list with them sorted by frequency
    public static ArrayList<Integer> getSortedIndexesByFrequency(ArrayList<Integer> frequencies) {
        ArrayList<Integer> indexes = new ArrayList<>(); // New list to hold numbers 0-25 (for letters)

        for (int i = 0; i < 26; i++) { // adds number to the list, same principle as the last time
            indexes.add(i);
        }

        // Starts to sort everything
        for (int i = 0; i < indexes.size() - 1; i++) {
            int freqPos = i; // this assumes that the most frequent letter is at position i

            for (int j = i + 1; j < indexes.size(); j++) { // this loop goes through the rest of the list to see if something is more frequent
                if (frequencies.get(indexes.get(j)) > frequencies.get(indexes.get(freqPos))) {
                    freqPos = j; //Updates to new most frequent
                }
            }

            // this swaps the values so that its all sorted
            int temp = indexes.get(i);
            indexes.set(i, indexes.get(freqPos));
            indexes.set(freqPos, temp);
        }

        return indexes;
    }

    public static char getLetterFromIndex(int i) { // method that takes integer i
        char letter = 'A';

        switch (i) { // Switch statement that checks number and converts it to letter
            case 0:  letter = 'A'; break;
            case 1:  letter = 'B'; break;
            case 2:  letter = 'C'; break;
            case 3:  letter = 'D'; break;
            case 4:  letter = 'E'; break;
            case 5:  letter = 'F'; break;
            case 6:  letter = 'G'; break;
            case 7:  letter = 'H'; break;
            case 8:  letter = 'I'; break;
            case 9:  letter = 'J'; break;
            case 10: letter = 'K'; break;
            case 11: letter = 'L'; break;
            case 12: letter = 'M'; break;
            case 13: letter = 'N'; break;
            case 14: letter = 'O'; break;
            case 15: letter = 'P'; break;
            case 16: letter = 'Q'; break;
            case 17: letter = 'R'; break;
            case 18: letter = 'S'; break;
            case 19: letter = 'T'; break;
            case 20: letter = 'U'; break;
            case 21: letter = 'V'; break;
            case 22: letter = 'W'; break;
            case 23: letter = 'X'; break;
            case 24: letter = 'Y'; break;
            case 25: letter = 'Z'; break;
        }

        return letter; // returns letter
    }

    // Writes frequencies and the top and bottom 5 into frequencies.txt
    public static void writeFrequencyFile(String outFile, ArrayList<Integer> frequencies, ArrayList<Integer> sortedIndexes) throws IOException {

        PrintWriter writer = new PrintWriter(outFile);

        // loops through the letters and turns numbers to letters
        for (int i = 0; i < 26; i++) {
            char letter = getLetterFromIndex(i);
            writer.println(letter + " = " + frequencies.get(i));
        }

        writer.println(); //blank space for formatting

        writer.println("Top 5 letters:");
        for (int i = 0; i < 5; i++) { // loops through the first 5 indexes in the sorted list
            int idx = sortedIndexes.get(i); // gets the index of the letter for one of the top 5
            char letter = getLetterFromIndex(idx); // converts said index to a letter
            writer.println(letter + " = " + frequencies.get(idx)); // Prints letter and its frequency
        }

        writer.println();

        writer.println("Bottom 5 letters:");
        for (int i = 21; i < 26; i++) { // same concept but reverse
            int idx = sortedIndexes.get(i);
            char letter = getLetterFromIndex(idx);
            writer.println(letter + " = " + frequencies.get(idx));
        }

        writer.close();
    }


    public static void main(String[] args) throws IOException { // the actual program

        ArrayList<String> lines = readFileLines("scarlet.txt"); // calls method that reads the file
        ArrayList<Integer> frequencies = getLetterFrequencies(lines); // sends the list to the method that counts the frequencies and stores said frequencies
        ArrayList<Integer> sortedIndexes = getSortedIndexesByFrequency(frequencies); // sorts the letters

        writeFrequencyFile("frequencies.txt", frequencies, sortedIndexes); // writes answer

        System.out.println("Finished, results in frequencies.txt"); // Exit msg so user knows the program ran
    }
}
