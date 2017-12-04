package pl.bialorucki;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CorruptionChecksumTest {
    @Test
    public void should_return_18() {
        int[][] testData = new int[][]{
                {5, 1, 9, 5,},
                {7, 5, 3},
                {2, 4, 6, 8}
        };

        assertEquals(18,CorruptionChecksum.countChecksum(testData));
    }
}