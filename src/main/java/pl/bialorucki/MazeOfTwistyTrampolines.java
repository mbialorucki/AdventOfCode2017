package pl.bialorucki;

/**
 * --- Day 5: A Maze of Twisty Trampolines, All Alike ---
 */
public class MazeOfTwistyTrampolines {

    public static int jump(int[] listOfJumps){
        int step = 0;
        int numberOfJumps = 0;
        int nextStep = 0;
        while(step >= 0 && step < listOfJumps.length){
            nextStep = listOfJumps[step];
            listOfJumps[step]++;
            step += nextStep;
            numberOfJumps++;
        }
        return numberOfJumps;
    }

}
