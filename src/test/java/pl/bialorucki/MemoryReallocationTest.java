package pl.bialorucki;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryReallocationTest {

    @Test
    public void findMaxIndex_should_return_minus_one_for_empty_list(){
        assertEquals(-1,MemoryReallocation.findMaxIndex(new ArrayList<>()));
    }

    @Test
    public void findMaxIndex_should_return_zero_element_for_one_element_list(){
        List<Integer> testList = new ArrayList<>();
        testList.add(1);
        assertEquals(0,MemoryReallocation.findMaxIndex(testList));
    }

    @Test
    public void redistribute_should_return_empty_list_for_empty_list(){
        assertEquals(0,MemoryReallocation.redistribute(new ArrayList<>()).size());
    }

    @Test
    public void redistribute_should_return_same_list_for_one_element_list(){
        List<Integer> testList = new ArrayList<>();
        testList.add(1);
        assertEquals(testList,MemoryReallocation.redistribute(testList));
    }

    @Test
    public void redistribute_should_return_2412_for_0270(){
        List<Integer> testList = Arrays.asList(0,2,7,0);
        List<Integer> resultList = MemoryReallocation.redistribute(testList);
        assertEquals(testList,resultList);
    }

    @Test
    public void detect_should_return_5_for_0270(){
        List<Integer> testList = Arrays.asList(0,2,7,0);
        assertEquals(5,MemoryReallocation.detect(testList));
    }

}