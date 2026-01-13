import java.util.*;

public class Words {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num = 5;

        String sentence = "";

        while (num > 0) {
            System.out.print("Enter word: ");
            String word = input.nextLine();
            sentence = sentence + word + " ";
            num--;
        }
        System.out.println(sentence);

    }
}
