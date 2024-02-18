import static org.junit.jupiter.api.Assertions.*;

class CharacterConverterTest {

    @org.junit.jupiter.api.Test
    void convertEnglishToMorseWorksAsExpected() {
        CharacterConverter characterConverter = new CharacterConverter();

        assertEquals("*", characterConverter.convertEnglishToMorse("E"));
        assertEquals("*---", characterConverter.convertEnglishToMorse("J"));
    }

    @org.junit.jupiter.api.Test
    void convertMorseToEnglishWorksAsExpected() {
        CharacterConverter characterConverter = new CharacterConverter();

        assertEquals("E", characterConverter.convertMorseToEnglish("*"));
        assertEquals("J", characterConverter.convertMorseToEnglish("*---"));
    }

    @org.junit.jupiter.api.Test
    void isSupportedEnglishCharacterWorksAsExpected() {
        CharacterConverter characterConverter = new CharacterConverter();

        // should be true for valid character
        assertTrue(characterConverter.isSupportedEnglishCharacter("A"));

        // should be false for invalid character
        assertFalse(characterConverter.isSupportedEnglishCharacter("£"));
    }

    @org.junit.jupiter.api.Test
    void isSupportedMorseCharacterWorksAsExpected() {
        CharacterConverter characterConverter = new CharacterConverter();

        // unsupported Morse character should be flagged as unsupported
        assertFalse(characterConverter.isSupportedMorseCharacter("*8***"));
    }
}