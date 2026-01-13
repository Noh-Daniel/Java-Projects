import java.util.*;

public class indMin {
    public static void main(String[] args) {
        getMin();
    }

    public static int getMin(int num1, int num2, int num3) {
        int min = num1;

        if (num2 < min) {
            min = num2;
        }
        if (num3 < min) {
            min = num3;
        }
        return min;
    }

    public static void getMin() {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.print("First integer: ");
            int num1 = scanner.nextInt();

            System.out.print("Second integer: ");
            int num2 = scanner.nextInt();

            System.out.print("Third integer: ");
            int num3 = scanner.nextInt();

            int minNum = getMin(num1, num2, num3);

            System.out.println("The smallest value is " + minNum);

            System.out.println("Go again (y for yes): ");
            choice = scanner.next();
        } while (choice.equals("y"));
    }
}
