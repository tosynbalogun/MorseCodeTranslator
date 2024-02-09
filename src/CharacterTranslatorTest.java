import static org.junit.jupiter.api.Assertions.*;

class CharacterTranslatorTest {

    @org.junit.jupiter.api.Test
    void translateEnglishToMorseWorksAsExpected() {
        CharacterTranslator characterTranslator = new CharacterTranslator();

        assertEquals("*", characterTranslator.translateEnglishToMorse("E"));
        assertEquals("*---", characterTranslator.translateEnglishToMorse("J"));
    }

    @org.junit.jupiter.api.Test
    void translateMorseToEnglishWorksAsExpected() {
        CharacterTranslator characterTranslator = new CharacterTranslator();

        assertEquals("E", characterTranslator.translateMorseToEnglish("*"));
        assertEquals("J", characterTranslator.translateMorseToEnglish("*---"));
    }

    @org.junit.jupiter.api.Test
    void isSupportedEnglishCharacterWorksAsExpected() {
        CharacterTranslator characterTranslator = new CharacterTranslator();

        // should be true for valid character
        assertTrue(characterTranslator.isSupportedEnglishCharacter("A"));

        // should be false for invalid character
        assertFalse(characterTranslator.isSupportedEnglishCharacter("£"));
    }

    @org.junit.jupiter.api.Test
    void isSupportedMorseCharacterWorksAsExpected() {
        CharacterTranslator characterTranslator = new CharacterTranslator();

        // unsupported Morse character should be flagged as unsupported
        assertFalse(characterTranslator.isSupportedMorseCharacter("*8***"));
    }
}