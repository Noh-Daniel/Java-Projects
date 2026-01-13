import java.util.*;

public class CheckSign {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        if (number < 0) {
            System.out.println("Number is negative");
        }

        else if (number > 0) {
            System.out.println("Number is positive");
        }

        else if (number == 0) {
            System.out.println("Number is zero");
        }
    }
}
