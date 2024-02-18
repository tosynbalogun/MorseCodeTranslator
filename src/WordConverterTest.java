import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordConverterTest {

    @Test
    void convertEnglishToMorseWorksAsExpected() {
        WordConverter wordConverter = new WordConverter();

        // should convert valid English word correctly
        assertEquals("**** * *---", wordConverter.convertEnglishToMorse("HEJ"));

        // should throw exception for invalid English word
        assertThrows(IllegalArgumentException.class, () -> wordConverter.convertEnglishToMorse("H£J"));

        // should throw exception for input with Space
        assertThrows(IllegalArgumentException.class, () -> wordConverter.convertEnglishToMorse("HE J"));
    }

    @Test
    void convertMorseToEnglishWorksAsExpected() {
        WordConverter wordConverter = new WordConverter();

        // should convert valid Morse word correctly
        assertEquals("HEJ", wordConverter.convertMorseToEnglish("**** * *---"));

        // should throw exception for invalid Morse word
        assertThrows(IllegalArgumentException.class, () -> wordConverter.convertMorseToEnglish("*8***"));
    }
}