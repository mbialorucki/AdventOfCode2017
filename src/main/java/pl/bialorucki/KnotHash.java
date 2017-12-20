package pl.bialorucki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * --- Day 10: Knot Hash ---
 */
public class KnotHash {

    public static int countSum(List<Integer> input){
        int initialIndex = 0;
        int skipSize = 0;
        List<Integer> list = IntStream.range(1, 256)
                                      .boxed()
                                      .collect(toList());
        for(Integer length : input){
            list = reverse(list,initialIndex,length);
            initialIndex = (initialIndex+length+skipSize) % list.size();
            skipSize++;
        }
        return list.get(0) + list.get(1);
    }


    public static List<Integer> reverse(List<Integer> list, int initialPosition, int length) {


        List<Integer> subList = new ArrayList<>();
        int initialIndex = initialPosition;
        while (length > 0) {
            int index = initialIndex % list.size();
            subList.add(list.get(index));
            initialIndex++;
            length--;
        }
        Collections.reverse(subList);
        for (Integer number : subList) {
            list.set(initialPosition, number);
            initialPosition++;
            initialPosition = initialPosition % list.size();
        }
        return list;
    }
}
