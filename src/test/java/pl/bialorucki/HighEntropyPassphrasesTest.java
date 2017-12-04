package pl.bialorucki;

import org.junit.jupiter.api.Test;

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
}