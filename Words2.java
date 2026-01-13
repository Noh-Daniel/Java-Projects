import java.util.*;

public class Words2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many words would u like to enter? ");
        int number = input.nextInt();

        String sentence = "";

        for (int i = 0; i < number; i++) {
            System.out.print("Enter word: ");
            String word = input.next();
            sentence = sentence + word + " ";
        }
        System.out.println(sentence);

    }
}
