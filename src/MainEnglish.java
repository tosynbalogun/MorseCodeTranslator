import java.util.Scanner;

public class MainEnglish {
    public static void main(String[] args) {
        WordTranslator wordTranslator = new WordTranslator();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nType in your English word (type STOP to exit): ");
            String line = scanner.nextLine();
            if (line.equals("STOP")) {
                break;
            }

            String morseTranslation = "";

            try {
                morseTranslation = wordTranslator.translateEnglishToMorse(line);
                System.out.println("Morse Translation: " + morseTranslation);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
