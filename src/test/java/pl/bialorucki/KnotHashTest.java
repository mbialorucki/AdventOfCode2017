package pl.bialorucki;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KnotHashTest {

    @Test
    public void should_return_2_1_0_for_0_1_2(){
        List<Integer> input = Arrays.asList(0,1,2);
        List<Integer> result = Arrays.asList(2,1,0);
        assertEquals(result,KnotHash.reverse(input,0,input.size()));
    }

    @Test
    public void should_return_0_1_4_3_2_5_6(){
        List<Integer> input = Arrays.asList(0,1,2,3,4,5,6);
        List<Integer> result = Arrays.asList(0,1,4,3,2,5,6);
        assertEquals(result,KnotHash.reverse(input,2,3));
    }

    @Test
    public void should_return(){
        List<Integer> input = Arrays.asList(2,1,0,3,4);
        List<Integer> result = Arrays.asList(4,3,0,1,2);
        assertEquals(result,KnotHash.reverse(input,3,4));
    }
}