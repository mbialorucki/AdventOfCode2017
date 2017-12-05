package pl.bialorucki;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeOfTwistyTrampolinesTest {


    int[] testJumpList = new int[]{0,3,0,1,-3};
    @Test
    public void should_return_5_for_test_data(){
        assertEquals(5,MazeOfTwistyTrampolines.jump(testJumpList));
    }

    @Test
    public void should_return_10_for_test_data(){
        assertEquals(10,MazeOfTwistyTrampolines.jumpWithDecrease(testJumpList));
    }


}