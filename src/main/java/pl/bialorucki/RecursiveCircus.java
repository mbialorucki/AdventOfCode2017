package pl.bialorucki;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * --- Day 7: Recursive Circus ---
 */
public class RecursiveCircus {

    public static String findName(String inputFile) {
        HashMap<String, List<String>> programs = new HashMap<>();
        try {
            for (String line : Files.readAllLines(Paths.get(inputFile))) {

                if (line.contains("->")) {
                    String programName = line.substring(0, line.indexOf(" "));
                    String[] holdingPrograms = line.split("->")[1].split(",");
                    List<String> trimmedPrograms = Arrays.stream(holdingPrograms)
                                                         .map(String::trim)
                                                         .collect(Collectors.toList());

                    programs.put(programName, trimmedPrograms);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String program : programs.keySet()) {
            if (!programs.values().stream().flatMap(List::stream).collect(Collectors.toList()).contains(program)) {
                return program;
            }
        }

        return "";
    }

    public static String findNameUsingLists(String inputFile){
        List<String> parentPrograms = new ArrayList<>();
        List<String> childPrograms = new ArrayList<>();

        try {
            for (String line : Files.readAllLines(Paths.get(inputFile))) {

                if (line.contains("->")) {
                    String programName = line.substring(0, line.indexOf(" "));
                    String[] holdingPrograms = line.split("->")[1].split(",");
                    List<String> trimmedPrograms = Arrays.stream(holdingPrograms)
                                                         .map(String::trim)
                                                         .collect(Collectors.toList());

                    parentPrograms.add(programName);
                    childPrograms.addAll(trimmedPrograms);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        parentPrograms.removeAll(childPrograms);
        return parentPrograms.get(0);
    }
}
