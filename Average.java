import java.util.*;

public class Average {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double sum = 0;
        int counter = 0;

        while (true) {
            System.out.print("Say a number (-1 to quit): ");
            int num = input.nextInt();

            if (num == -1) break;
            if (num < -1) continue;

            sum += num;
            counter++;
        }

        if (counter > 0) {
            System.out.println("Sum: " + sum);
            System.out.println("Average: " + (sum / counter));
        } else {
            System.out.println("No numbers entered.");
        }
    }
}
