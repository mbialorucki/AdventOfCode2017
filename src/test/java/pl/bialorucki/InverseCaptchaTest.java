package pl.bialorucki;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InverseCaptchaTest {

    @Test
    public void should_return_9() {
        String testString = "91212129";
        assertEquals(9, InverseCaptcha.sum(testString));
    }

    @Test
    public void should_return_4() {
        String testString = "1111";
        assertEquals(4, InverseCaptcha.sum(testString));
    }

    @Test
    public void should_return_0() {
        String testString = "1234";
        assertEquals(0, InverseCaptcha.sum(testString));
    }

    @Test
    public void should_return_3() {
        String testString = "1122";
        assertEquals(3, InverseCaptcha.sum(testString));
    }
}