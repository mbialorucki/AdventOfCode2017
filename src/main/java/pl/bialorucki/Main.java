package pl.bialorucki;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        //region Day1 - Inverse Captcha
        String testString = "516299281491169512719425276194596424291268712697155863651846937925928456958813624428156" +
                "218468331423858422613471962165756423837756856519754524985759763747559711257977361228357678293572698" +
                "839754444752898835313399815748562519958329927911861654784216355489319995566297499836295985943899373" +
                "615223375271231128914745273184498915241488393761676799914385265459983923743146555465177886491979962" +
                "465918888396664233693243983969412682561799628789569294374554575677368219724142536789649121758582991" +
                "345537639888858113763738518511184439854223386868764189133964543721941169786274781775658991329331759" +
                "679943342217578532643519615296424396487669451453728113114748217177826874953466435436129165295379157" +
                "226345786756899935747336785161745487933721527239394118721517195849186676814232887413175587327214144" +
                "876898248571248517121796766248817366614333915154796983612174281237846165129114988453188844745119798" +
                "643314857871527757831265298846833327863781341559381238458322786192379487455671563757123534253463563" +
                "421716138641611915686247343417126655317378639314168461345613427262786624689498485599942336813995725" +
                "145169355942616672812792174556866436158375938988738721253664772584577384558696477546232189312287262" +
                "439452141564522329987139692281984783513691857538335537553448919819545332125483128878925492334361562" +
                "192621672993868479566688564752226111784486619789588318171745995253645886833872665447241245329935643" +
                "883892447524286642296955354249478815116517315832179925494818748478164317669471654464867111924676961" +
                "162162841232473474394739793968624974397916495667233337397241933765513777241916359166994384923869741" +
                "468174653353541147616645393917694581811193977311981752554551499629219873391493426883886536219455848" +
                "354426461562995284162323961773644581815633779762634745339565196798724847722781666948626231631632144" +
                "371873154872575615636322965353254642186897127423352618879431499138418872356116624818733232445649188" +
                "793318829748789349813295218673497291134164395739665667255443366383299669973689528188264386373591424" +
                "149784473698487315316676637165317972648916116755224598519934598889627918883283534261513179931798591" +
                "959489372165295";
        System.out.println(InverseCaptcha.sum(testString));
        //endregion
        //region Day2 - Corruption Checksum
        int[][] inputData = new int[][]{
                {5048, 177, 5280, 5058, 4504, 3805, 5735, 220, 4362, 1809, 1521, 230, 772, 1088, 178, 1794},
                {6629, 3839, 258, 4473, 5961, 6539, 6870, 4140, 4638, 387, 7464, 229, 4173, 5706, 185, 271},
                {5149, 2892, 5854, 2000, 256, 3995, 5250, 249, 3916, 184, 2497, 210, 4601, 3955, 1110, 5340},
                {153, 468, 550, 126, 495, 142, 385, 144, 165, 188, 609, 182, 439, 545, 608, 319},
                {1123, 104, 567, 1098, 286, 665, 1261, 107, 227, 942, 1222, 128, 1001, 122, 69, 139},
                {111, 1998, 1148, 91, 1355, 90, 202, 1522, 1496, 1362, 1728, 109, 2287, 918, 2217, 1138},
                {426, 372, 489, 226, 344, 431, 67, 124, 120, 386, 348, 153, 242, 133, 112, 369},
                {1574, 265, 144, 2490, 163, 749, 3409, 3086, 154, 151, 133, 990, 1002, 3168, 588, 2998},
                {173, 192, 2269, 760, 1630, 215, 966, 2692, 3855, 3550, 468, 4098, 3071, 162, 329, 3648},
                {1984, 300, 163, 5616, 4862, 586, 4884, 239, 1839, 169, 5514, 4226, 5551, 3700, 216, 5912},
                {1749, 2062, 194, 1045, 2685, 156, 3257, 1319, 3199, 2775, 211, 213, 1221, 198, 2864, 2982},
                {273, 977, 89, 198, 85, 1025, 1157, 1125, 69, 94, 919, 103, 1299, 998, 809, 478},
                {1965, 6989, 230, 2025, 6290, 2901, 192, 215, 4782, 6041, 6672, 7070, 7104, 207, 7451, 5071},
                {1261, 77, 1417, 1053, 2072, 641, 74, 86, 91, 1878, 1944, 2292, 1446, 689, 2315, 1379},
                {296, 306, 1953, 3538, 248, 1579, 4326, 2178, 5021, 2529, 794, 5391, 4712, 3734, 261, 4362},
                {2426, 192, 1764, 288, 4431, 2396, 2336, 854, 2157, 216, 4392, 3972, 229, 244, 4289, 1902}
        };
        System.out.println(CorruptionChecksum.countChecksum(inputData));
        //endregion
        //region Day4 - High-Entropy Passphrases
        int numberOfValidPassPhrases = 0;
        try {
            for(String line : Files.readAllLines(Paths.get("src/main/resources/passphrases"))){
                if(HighEntropyPassphrases.check(line)){
                    numberOfValidPassPhrases++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            }
        System.out.println(numberOfValidPassPhrases);
        //endregion
        //region Day5 - A Maze of Twisty Trampolines, All Alike
        List<Integer> maze = new ArrayList<>();
        try {
            for(String line : Files.readAllLines(Paths.get("src/main/resources/maze"))){
               int number = Integer.parseInt(line);
               maze.add(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int result = MazeOfTwistyTrampolines.jump(maze.stream().mapToInt(Integer::valueOf).toArray());
        int resultWithDecrease = MazeOfTwistyTrampolines.jumpWithDecrease(maze.stream().mapToInt(Integer::valueOf).toArray());
        System.out.println(result);
        System.out.println(resultWithDecrease);
        //endregion
        //region Day6 - Memory Reallocation
        List<Integer> memoryBank = Arrays.asList(5,1,10,0,1,7,13,14,3,12,8,10,7,12,0,6);
        System.out.println(MemoryReallocation.detect(memoryBank));
        System.out.println(MemoryReallocation.countCycles(memoryBank));
        //endregion
        //region Day 7 - Recursive circus
        System.out.println(RecursiveCircus.findNameUsingLists("src/main/resources/programs"));
        //endregion
        //region Day 8 - I Heard You Like Registers
        System.out.println(Arrays.toString(Registers.findMaxRegisterValue("src/main/resources/registers")));
        //endregion
        //region Day 9: Stream Processing
        System.out.println(StreamProcessing.countGroups("src/main/resources/stream_processing"));
        System.out.println(StreamProcessing.countCharacters("src/main/resources/stream_processing"));

        //endregion
        //region Day 10 : Knot Hash
        List<Integer> input = Arrays.asList(227,169,3,166,246,201,0,47,1,255,2,254,96,3,97,144);
        System.out.println(KnotHash.countSum(input));
        //endregion
        //region Day 12 : Digital Plumber
        System.out.println(DigitalPlumber.find("src/main/resources/plumber"));
        //endregion
        //region Day 16 : Permutation Promenade
        System.out.println(PermutationPromenade.dance(Utils.readFileContent("src/main/resources/permutation_promenade").get(0)));
        //endregion
    }


}
