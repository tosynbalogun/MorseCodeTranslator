public class WordTranslator {
    private final CharacterTranslator characterTranslator;

    public WordTranslator() {
        this.characterTranslator = new CharacterTranslator();
    }

    private void confirmEnglishWordValidity(String word) throws IllegalArgumentException {
        // check if word contains spaces
        if (word.contains(" ")) {
            throw new IllegalArgumentException("English words don't contain spaces.");
        }

        // check if each character is supported by the translator
        String[] wordCharacters = word.split("");
        for (String wordCharacter : wordCharacters) {
            if (!this.characterTranslator.isSupportedEnglishCharacter(wordCharacter)) {
                throw new IllegalArgumentException(
                        String.format("The '%s' English character is not supported by the translator", wordCharacter)
                );
            }
        }
    }

    private void confirmMorseWordValidity(String word) throws IllegalArgumentException {
        // check if each character group is supported by the translator
        String[] morseCharacterGroups = word.split(" ");
        for (String morseCharacterGroup: morseCharacterGroups) {
            if (!this.characterTranslator.isSupportedMorseCharacter(morseCharacterGroup)) {
                throw new IllegalArgumentException(
                        String.format("The '%s' Morse character group is not supported by the translator", morseCharacterGroup)
                );
            }
        }
    }

    public String translateEnglishToMorse(String englishWord) throws IllegalArgumentException {
        // confirm that the word is valid English
        this.confirmEnglishWordValidity(englishWord);

        String morseWord = "";
        String[] englishCharacters = englishWord.split("");

        for (String englishCharacter : englishCharacters) {
            // add corresponding Morse character
            morseWord = morseWord.concat(this.characterTranslator.translateEnglishToMorse(englishCharacter));
            // add a separating space
            morseWord = morseWord.concat(" ");
        }

        // remove trailing space
        morseWord = morseWord.trim();

        return morseWord;
    }

    public String translateMorseToEnglish(String morseWord) throws IllegalArgumentException {
        // confirm that the word is valid Morse
        this.confirmMorseWordValidity(morseWord);

        String englishWord = "";
        String[] morseCharacterGroups = morseWord.split(" ");

        for (String morseCharacterGroup: morseCharacterGroups) {
            // add corresponding English character
            englishWord = englishWord.concat(this.characterTranslator.translateMorseToEnglish(morseCharacterGroup));
        }

        return englishWord;
    }
}
