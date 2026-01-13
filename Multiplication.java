import java.util.*;

public class Multiplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number between 1 and 12: ");
        int number = input.nextInt();
        int num = 0;

        if (number <= 0 || number > 12) {
            System.out.println("Invalid number");
            System.exit(0);
        }

        else {
            for (int i = 0; i < 13; i++) {
                System.out.println(number + " x " + num + " = " + (number * num));
                num++;
            }
        }
    }
}
