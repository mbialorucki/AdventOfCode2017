package pl.bialorucki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * --- Day 10: Knot Hash ---
 */
public class KnotHash {
    static int[] list;


    public static int twist(int[] lengths){
        list = IntStream.range(1,256).toArray();
        return 0;
    }

    public static void reverse(int[] tab,int initialPosition,int length){
        for(int i = initialPosition ; i < (initialPosition + length)/2 ; i++){
            int tmp = tab[i%length];
            tab[i%length] = tab[length-i-1];
            tab[length-i-1] = tmp;
        }
    }
}
