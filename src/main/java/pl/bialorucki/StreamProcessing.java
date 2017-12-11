package pl.bialorucki;

/**
 * --- Day 9: Stream Processing ---
 */
public class StreamProcessing {

    public static  int countGroups(){
        return 0;
    }

    public boolean isGarbage(String line){
        if(Utils.isNullOrEmpty(line)){
            return false;
        }

        if(line.startsWith("<") && line.endsWith(">") && line.charAt(line.length()-2) != '!'){
            return true;
        }

        return false;
    }
}
