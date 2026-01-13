/*
Noh Daniel
Ms. Ogle
November 17th, 2025
Description: Makes 52 card deck, shuffles, and plays the cards while giving added values of all cards in a hand
 */

import java.util.*;

public class A2Q1 {

    static String[] values = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"}; // Array to store all card values, string in front because it is a class level variable
    static String[] suits  = {"Clubs","Spades","Hearts","Diamonds"}; // Array for different card types, the suits
    static String[] deck   = new String[52];  // Array that holds deck

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the card shuffler and dealer!");

        createDeck(); // Calls create deck method I coded below

        boolean running = true;  // Boolean that is used to confirm if user wants to still play

        while (running) {  // Loops until running is 'false'

            printMenu(); // Prints the menu, menu is made in the method defined later

            int choice = 0;

            try {
                choice = input.nextInt();  // Gets user menu choice
            } catch (InputMismatchException e) {  // Checks if user writes anything but a number between 1-4
                System.out.println("Invalid input. Enter 1–4");
                input.nextLine(); // Clears the input so the program doesn't break
                continue; // Goes back to the menu
            }

            if (choice == 1) {
                printDeck(); // Calls the print deck method defined below
            }
            else if (choice == 2) {
                shuffleDeck(); // Calls shuffle deck method defined below
            }
            else if (choice == 3) {
                dealCards(input); // Calls dealcards method defined below
            }
            else if (choice == 4) {
                System.out.println("Exiting program"); // Exit option, quits program
                running = false; // Ends loop
            }
            else {
                System.out.println("Invalid choice"); // If not any of those, must be invalid
            }
        }
    }

    private static void printMenu() {  // Method that has the menu and stores it to be called
        System.out.println("\nMenu");
        System.out.println("1 - Print deck");
        System.out.println("2 - Shuffle deck");
        System.out.println("3 - Deal cards");
        System.out.println("4 - Exit");
        System.out.print("Choose (1-4): ");
    }

    private static void createDeck() {  // Method that creates the deck by filling it with all 52 cards
        int index = 0;
        for (int i = 0; i < suits.length; i++) {  // Loops through each suit
            for (int j = 0; j < values.length; j++) { // Loops through each value
                deck[index] = values[j] + " of " + suits[i];  // Makes the card name
                index++; // Moves to next card in deck
            }
        }
    }

    private static void printDeck() {  // Method that calls deck
        System.out.println("Current Deck"); // Title for the deck
        for (int i = 0; i < deck.length; i++) { // Sift through all cards
            System.out.println(deck[i]); // Prints said card
        }
    }

    private static void shuffleDeck() {  // Method that shuffles the deck
        Random rand = new Random(); // Calling random to use for shuffling

        for (int i = 0; i < deck.length; i++) { // Goes through each card in deck
            int r = rand.nextInt(deck.length); // Finds random spot in the deck
            // Swaps current card with a random card, simulating a "shuffle"
            String temp = deck[i];
            deck[i] = deck[r];
            deck[r] = temp;
        }

        System.out.println("Deck has been shuffled"); // Tells user its shuffled

        // Checks to make sure no cards were lost during shuffling
        if (verifyDeck()) {
            System.out.println("All 52 unique cards present.");
        } else {
            System.out.println("Duplicate or missing card detected"); // A card is missing or duplicated, inform user
            System.out.println("Fixing deck"); // Tells user that the deck is being remade

            createDeck(); // Makes new deck with all cards in it

            System.out.println("Fresh deck has been made"); // Tells user the deck is fixed
        }
    }

    private static boolean verifyDeck() {
        for (int i = 0; i < deck.length; i++) {
            if (deck[i] == null) return false; // Makes sure no cards are null (no empty variables)
        }
        // Checks every card against each other to make sure no duplicates are there
        for (int i = 0; i < deck.length; i++) {
            for (int j = i + 1; j < deck.length; j++) {
                if (deck[i].equals(deck[j])) return false; // If there are, it'll rebuild the deck
            }
        }
        return true;  // Means deck is valid
    }

    private static void dealCards(Scanner input) {

        int hands = 0;
        int cardsEach = 0;

        while (true) { // Loop that asks for input until user enters valid numbers
            try {
                System.out.print("Enter number of hands: ");
                hands = input.nextInt();

                System.out.print("Enter number of cards per hand: ");
                cardsEach = input.nextInt();

                // Validation checks
                if (hands <= 1 || hands >= 52) {
                    System.out.println("Hands must be > 1 and < 52");
                } else if (cardsEach <= 0) {
                    System.out.println("Cards per hand must be > 0");
                } else if (hands * cardsEach >= 52) {
                    System.out.println("Total cards dealt must be < 52");
                } else {
                    break;
                }

            } catch (InputMismatchException e) { // Exception handling for if input isnt a number
                System.out.println("Invalid input, enter whole numbers only.");
                input.nextLine(); // Clears input
            }
        }

        int deckIndex = 0; // Checks position in deck while dealing

        for (int h = 1; h <= hands; h++) {

            System.out.println("\nHand #" + h + ":");

            int sum = 0; // Total value of hand is stored here

            for (int c = 0; c < cardsEach; c++) { // Deals cards

                String card = deck[deckIndex]; // Gets card from deck
                System.out.println(card); // Deals it to user

                String value = card.split(" ")[0]; // Splits string to get just the value from a card (Don't fully understand but Luke said so)

                sum += cardPoints(value); // Adds the point value of the cards to the hand

                deckIndex++; // Goes to next card
            }

            System.out.println("Total = " + sum); // Prints total for the hand
        }
    }

    // Method that assigns values to cards
    private static int cardPoints(String v) {
        // Needed because these are strings, not ints, so I have to convert it like this.
        if (v.equals("A"))  return 11;
        if (v.equals("K"))  return 10;
        if (v.equals("Q"))  return 10;
        if (v.equals("J"))  return 10;
        if (v.equals("10")) return 10;
        if (v.equals("9"))  return 9;
        if (v.equals("8"))  return 8;
        if (v.equals("7"))  return 7;
        if (v.equals("6"))  return 6;
        if (v.equals("5"))  return 5;
        if (v.equals("4"))  return 4;
        if (v.equals("3"))  return 3;
        if (v.equals("2"))  return 2;

        return 0; // Default, will never reach this though
    }
}
