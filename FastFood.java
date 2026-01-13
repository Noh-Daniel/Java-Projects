import java.util.Scanner;

public class FastFood {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double total = 0;
        int choice;

        do {
            System.out.println("Fast Food Menu");
            System.out.println("1. Burger - $5.99");
            System.out.println("2. Fries - $2.99");
            System.out.println("3. Soda - $1.99");
            System.out.println("4. Chicken Nuggets - $4.99");
            System.out.println("5. Ice Cream - $3.99");
            System.out.println("6. Salad - $3.99");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    total += 5.99;
                    System.out.println("Burger added");
                    break;
                case 2:
                    total += 2.99;
                    System.out.println("Fries added");
                    break;
                case 3:
                    total += 1.99;
                    System.out.println("Soda added");
                    break;
                case 4:
                    total += 4.99;
                    System.out.println("Chicken Nuggets added");
                    break;
                case 5:
                    total += 3.99;
                    System.out.println("Ice Cream added");
                    break;
                case 6:
                    total += 3.99;
                    System.out.println("Salad added");
                    break;
                case 7:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }

        } while (choice != 7);

        System.out.printf("Your total is: " + total);
    }
}
