package pl.bialorucki;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StreamProcessingTest {

    @Test
    public void should_return_9_for_sample_input(){
        assertEquals(9,StreamProcessing.countGroups("src/main/resources/stream_processing_sample"));
    }

}