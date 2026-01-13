import java.util.*;

public class GreaterNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        System.out.print("Enter an integer: ");
        int number2 = input.nextInt();
        System.out.print("Enter an integer: ");
        int number3 = input.nextInt();

        if (number > number2) {
            if (number > number3) {
                System.out.println(number + " is the greater number");
            }
            else {
                System.out.println(number3 + " is the greater number");
            }
        }
        else if (number < number2) {
            if (number2 > number3) {
                System.out.println(number2 + " is the greater number");
            }
            else {
                System.out.println(number3 + " is the greater number");
            }
        }
        if (number == number2) {
            if (number == number3) {
                System.out.println("They are equal");
            }

        }
    }
}
