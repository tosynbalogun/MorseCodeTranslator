import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WordConverter wordConverter = new WordConverter();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nType in your Morse word (type STOP to exit): ");
            String line = scanner.nextLine();
            if (line.equals("STOP")) {
                break;
            }

            String englishConversion;

            try {
                englishConversion = wordConverter.convertMorseToEnglish(line);
                System.out.println("English Conversion: " + englishConversion);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }


        while (true) {
            System.out.print("\nType in your English word (type STOP to exit): ");
            String line = scanner.nextLine();
            if (line.equals("STOP")) {
                break;
            }

            String morseConversion;

            try {
                morseConversion = wordConverter.convertEnglishToMorse(line);
                System.out.println("Morse Conversion: " + morseConversion);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}