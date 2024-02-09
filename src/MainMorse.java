import java.util.Scanner;

public class MainMorse {
    public static void main(String[] args) {
        WordTranslator wordTranslator = new WordTranslator();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nType in your Morse word (type STOP to exit): ");
            String line = scanner.nextLine();
            if (line.equals("STOP")) {
                break;
            }

            String englishTranslation = "";

            try {
                englishTranslation = wordTranslator.translateMorseToEnglish(line);
                System.out.println("English Translation: " + englishTranslation);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}