package pl.bialorucki;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class KnotHashTest {


    @Test
    public void should_reverse_array(){
        int[] input = new int[]{0,1,2,3,4};
        KnotHash.reverse(input,0,3);
        assertTrue(Arrays.equals(new int[]{2,1,0,3,4},input));
    }

    @Test
    @Disabled
    public void should_reverse_array_with_overlap(){
        int[] input = new int[]{2,1,0,3,4};
        int[] result = {4, 3, 0, 1, 2};
        KnotHash.reverse(input,3,4);
        assertEquals(result,input);
        assertTrue(Arrays.equals(result,input));
    }
}