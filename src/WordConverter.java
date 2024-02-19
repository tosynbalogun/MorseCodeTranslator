public class WordConverter {
    private final CharacterConverter characterConverter;

    public WordConverter() {
        this.characterConverter = new CharacterConverter();
    }

    private void confirmEnglishWordValidity(String word) throws IllegalArgumentException {
        // check if word contains spaces
        if (word.contains(" ")) {
            throw new IllegalArgumentException("English words don't contain spaces.");
        }

        // check if each character is supported by the translator
        String[] wordCharacters = word.split("");
        for (String wordCharacter : wordCharacters) {
            if (!this.characterConverter.isSupportedEnglishCharacter(wordCharacter)) {
                throw new IllegalArgumentException(
                        String.format("The '%s' English character is not supported by the converter", wordCharacter)
                );
            }
        }
    }

    private void confirmMorseWordValidity(String word) throws IllegalArgumentException {
        // check if each character group is supported by the translator
        String[] morseCharacterGroups = word.split(" ");
        for (String morseCharacterGroup: morseCharacterGroups) {
            if (!this.characterConverter.isSupportedMorseCharacter(morseCharacterGroup)) {
                throw new IllegalArgumentException(
                        String.format("The '%s' Morse character group is not supported by the converter", morseCharacterGroup)
                );
            }
        }
    }

    public String convertEnglishToMorse(String englishWord) throws IllegalArgumentException {
        // confirm that the word is valid English
        this.confirmEnglishWordValidity(englishWord);

        String morseWord = "";
        String[] englishCharacters = englishWord.split("");

        for (String englishCharacter : englishCharacters) {
            // add corresponding Morse character
            morseWord = morseWord.concat(this.characterConverter.convertEnglishToMorse(englishCharacter));
            // add a separating space
            morseWord = morseWord.concat(" ");
        }

        // remove trailing space
        morseWord = morseWord.trim();

        return morseWord;
    }

    public String convertMorseToEnglish(String morseWord) throws IllegalArgumentException {
        // confirm that the word is valid Morse
        this.confirmMorseWordValidity(morseWord);

        String englishWord = "";
        String[] morseCharacterGroups = morseWord.split(" ");

        for (String morseCharacterGroup: morseCharacterGroups) {
            // add corresponding English character
            englishWord = englishWord.concat(this.characterConverter.convertMorseToEnglish(morseCharacterGroup));
        }

        return englishWord;
    }
}
