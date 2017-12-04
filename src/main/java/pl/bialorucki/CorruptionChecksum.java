package pl.bialorucki;

import java.util.Arrays;

/**
 * --- Day 2: Corruption Checksum ---
 */
public class CorruptionChecksum {

    public static int countChecksum(int[][] inputData){
        int checksum = 0;
        for(int[] row : inputData){
            int minimum = Arrays.stream(row).min().getAsInt();
            int maximum = Arrays.stream(row).max().getAsInt();
            int difference = maximum - minimum;
            checksum+=difference;
        }
        return checksum;
    }
}