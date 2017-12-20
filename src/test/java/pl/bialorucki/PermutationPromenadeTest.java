package pl.bialorucki;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PermutationPromenadeTest {


    @Test
    public void spin_should_return_cdeab_for_abcde(){
        List<Character> list = Arrays.asList('a', 'b', 'c', 'd', 'e');
        Collections.rotate(list,3);
        assertEquals(Arrays.asList('c','d','e','a','b'),list );
    }

    @Test
    public void exchange_should_return_eabdc_for_eabcd(){
        assertEquals(Arrays.asList('e','a','b','d','c'),PermutationPromenade.exchange(Arrays.asList('e','a','b','c','d'),3,4));
    }

    @Test
    public void partner_should_return_baedc_for_eabdc(){
        assertEquals(Arrays.asList('b','a','e','d','c'),PermutationPromenade.partner(Arrays.asList('e','a','b','d','c'),'e','b'));
    }

}