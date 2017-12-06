package pl.bialorucki;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * --- Day 6: Memory Reallocation ---
 */
public class MemoryReallocation {

    public static int detect(List<Integer> memoryBank) {
        List<List<Integer>> seenedBlocks = new ArrayList<>();

        seenedBlocks.add(new ArrayList<>(memoryBank));
        while(true){
            redistribute(memoryBank);
            if(seenedBlocks.contains(memoryBank))
                return seenedBlocks.size();
            seenedBlocks.add(new ArrayList<>(memoryBank));
        }
    }

    public static List<Integer> redistribute(List<Integer> memoryBank) {
        if(memoryBank.isEmpty())
            return new ArrayList<>();

        int maxIndex = findMaxIndex(memoryBank);
        int maxValue = memoryBank.get(maxIndex);

        memoryBank.set(maxIndex,0);

        while(maxValue > 0){
            maxIndex++;
            maxIndex = maxIndex%memoryBank.size();
            memoryBank.set(maxIndex,memoryBank.get(maxIndex)+1);
            maxValue--;
        }
        if(maxIndex == memoryBank.size()-1){
            maxIndex--;
        }
        return new ArrayList<>(memoryBank);
    }

    public static int findMaxIndex(List<Integer> memoryBank) {
        if (memoryBank.isEmpty())
            return -1;
        int maxValue = memoryBank.stream().max(Comparator.naturalOrder()).get();
        return memoryBank.indexOf(maxValue);
    }
}