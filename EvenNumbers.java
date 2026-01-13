import java.util.*;

public class EvenNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number greater than 0: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Please restart and enter a number greater than 0");
            System.exit(0);
        }

        int i = 2;
        while (i <= number) {
            System.out.println(i);
            i += 2;
        }    }
}
