package pl.bialorucki;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HighEntropyPassphrasesTest {
    @Test
    public void should_return_true_for_non_duplicated_words(){
        String testPassphrase = "aa bb cc dd ee";
        assertTrue(HighEntropyPassphrases.check(testPassphrase));
    }

    @Test
    public void should_return_false_for_duplicated_words(){
        String testPassphrase = "aa bb cc dd aa";
        assertFalse(HighEntropyPassphrases.check(testPassphrase));
    }

    @Test
    public void should_return_true_for_sililar_words(){
        String testPassphrase = "aa bb cc dd aaa";
        assertTrue(HighEntropyPassphrases.check(testPassphrase));
    }

    @Test
    public void should_detect_anagram(){
        String firstString = "abcde";
        String secondString = "ecdab";
        assertTrue(HighEntropyPassphrases.isAnagram(firstString,secondString));
    }

    @Test
    public void should_detect_not_anagram(){
        String firstString = "abc";
        String secondString = "zhh";
        assertFalse(HighEntropyPassphrases.isAnagram(firstString,secondString));
    }
    @Test
    public void should_detect_not_anagram_for_diffren_string_lengths(){
        String firstString = "abc";
        String secondString = "z";
        assertFalse(HighEntropyPassphrases.isAnagram(firstString,secondString));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcde fghij","a ab abc abd abf abj","iiii oiii ooii oooi oooo"})
    public void should_return_true_for_non_anagram_items(String passPhrase){
        assertTrue(HighEntropyPassphrases.checkUsingAnagramDetection(passPhrase));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcde xyz ecdab","oiii ioii iioi iiio"})
    public void should_return_false_for_anagram_items(String passPhrase){
        assertFalse(HighEntropyPassphrases.checkUsingAnagramDetection(passPhrase));
    }
}