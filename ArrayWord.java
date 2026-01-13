import java.util.*;

public class ArrayWord {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();

        System.out.println("Enter 5 words:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Word " + (i + 1) + ": ");
            words.add(input.next());
        }

        System.out.println("Original ArrayList:");
        System.out.println(words);

        System.out.print("Enter a maximum word length: ");
        int maxLength = input.nextInt();

        words.removeIf(word -> word.length() > maxLength);

        System.out.println("Words with length <= " + maxLength + "):");
        System.out.println(words);
    }
}
