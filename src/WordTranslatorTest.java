import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordTranslatorTest {

    @Test
    void translateEnglishToMorseWorksAsExpected() {
        WordTranslator wordTranslator = new WordTranslator();

        // should translate valid English word correctly
        assertEquals("**** * *---", wordTranslator.translateEnglishToMorse("HEJ"));

        // should throw exception for invalid English word
        assertThrows(IllegalArgumentException.class, () -> wordTranslator.translateEnglishToMorse("H£J"));
    }

    @Test
    void translateMorseToEnglishWorksAsExpected() {
        WordTranslator wordTranslator = new WordTranslator();

        // should translate valid Morse word correctly
        assertEquals("HEJ", wordTranslator.translateMorseToEnglish("**** * *---"));

        // should throw exception for invalid Morse word
        assertThrows(IllegalArgumentException.class, () -> wordTranslator.translateMorseToEnglish("*8***"));
    }
}