import java.util.HashMap;

public class CharacterConverter {
    private final HashMap<String, String> englishToMorse;
    private final HashMap<String, String> morseToEnglish;
    public CharacterConverter() {
        this.englishToMorse = new HashMap<>();
        this.morseToEnglish = new HashMap<>();

        // populate the English to Morse Hash Map
        this.englishToMorse.put("A", "*-");
        this.englishToMorse.put("B", "-***");
        this.englishToMorse.put("C", "-*-*");
        this.englishToMorse.put("D", "-**");
        this.englishToMorse.put("E", "*");
        this.englishToMorse.put("F", "**-*");
        this.englishToMorse.put("G", "--*");
        this.englishToMorse.put("H", "****");
        this.englishToMorse.put("I", "**");
        this.englishToMorse.put("J", "*---");
        this.englishToMorse.put("K", "-*-");
        this.englishToMorse.put("L", "*-**");
        this.englishToMorse.put("M", "--");
        this.englishToMorse.put("N", "-*");
        this.englishToMorse.put("O", "---");
        this.englishToMorse.put("P", "*--*");
        this.englishToMorse.put("Q", "--*-");
        this.englishToMorse.put("R", "*-*");
        this.englishToMorse.put("S", "***");
        this.englishToMorse.put("T", "-");
        this.englishToMorse.put("U", "**-");
        this.englishToMorse.put("V", "***-");
        this.englishToMorse.put("W", "*--");
        this.englishToMorse.put("X", "-**-");
        this.englishToMorse.put("Y", "-*--");
        this.englishToMorse.put("Z", "--**");
        this.englishToMorse.put("1", "*----");
        this.englishToMorse.put("2", "**---");
        this.englishToMorse.put("3", "***--");
        this.englishToMorse.put("4", "****-");
        this.englishToMorse.put("5", "*****");
        this.englishToMorse.put("6", "-****");
        this.englishToMorse.put("7", "--***");
        this.englishToMorse.put("8", "---**");
        this.englishToMorse.put("9", "----*");
        this.englishToMorse.put("0", "-----");
        this.englishToMorse.put(".", "*-*-*-");
        this.englishToMorse.put(",", "--**--");
        this.englishToMorse.put("?", "**--**");

        // populate the Morse to English map
        this.englishToMorse.forEach((english, morse) -> this.morseToEnglish.put(morse, english));
    }

    public String convertEnglishToMorse(String englishCharacter) {
        return this.englishToMorse.get(englishCharacter);
    }

    public String convertMorseToEnglish(String morseCharacter) {
        return this.morseToEnglish.get(morseCharacter);
    }

    public boolean isSupportedEnglishCharacter(String englishCharacter) {
        return this.englishToMorse.containsKey(englishCharacter);
    }

    public boolean isSupportedMorseCharacter(String morseCharacter) {
        return this.morseToEnglish.containsKey(morseCharacter);
    }
}
