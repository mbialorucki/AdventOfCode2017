package pl.bialorucki;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveCircusTest {

    @Test
    public void findName_should_return_tknk_for_sample_data(){
        assertEquals("tknk",RecursiveCircus.findName("src/main/resources/programs_sample"));
    }

    @Test
    public void findNameUsingLists_should_return_tknk_for_sample_data(){
        assertEquals("tknk",RecursiveCircus.findNameUsingLists("src/main/resources/programs_sample"));
    }


}