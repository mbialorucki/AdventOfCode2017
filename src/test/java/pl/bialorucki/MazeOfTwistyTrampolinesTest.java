package pl.bialorucki;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeOfTwistyTrampolinesTest {


    @Test
    public void should_return_5_for_test_data(){
        int[] testJumpList = new int[]{0,3,0,1,-3};
        assertEquals(5,MazeOfTwistyTrampolines.jump(testJumpList));
    }
}