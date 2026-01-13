import java.util.*;

public class CalcHyp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String cont;

        do {
            System.out.print("Enter the first side of the triangle: ");
            double sideA = input.nextDouble();
            if (sideA<=0){
                System.out.println("Invalid side");
                return;
            }

            System.out.print("Enter the second side of the triangle: ");
            double sideB = input.nextDouble();

            if (sideB<=0){
                System.out.println("Invalid side");
                return;
            }

            double hypotenuse = getHyp(sideA, sideB);
            System.out.println("The length of the hypotenuse is: " + hypotenuse);

            System.out.print("Would you like to calculate another? (y/n): ");
            cont = input.next();

        } while (cont.equals("y"));

    }
    public static double getHyp(double sideA, double sideB) {
        return Math.sqrt((sideA * sideA) + (sideB * sideB));
    }
}
