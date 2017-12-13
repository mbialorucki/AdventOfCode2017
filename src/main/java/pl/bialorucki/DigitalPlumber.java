package pl.bialorucki;

import java.util.*;
import java.util.stream.Collectors;

/**
 * --- Day 12: Digital Plumber ---
 */
public class DigitalPlumber {

    private static Map<Integer, List<Integer>> programs;
    private static List<Integer> connections;

    public static int find(String fileName) {
        List<String> input = Utils.readFileContent(fileName);

        programs = new HashMap<>();
        connections = new ArrayList<>();

        mapPrograms(input);
        findDirectConnections();

        for (Integer value : connections.toArray(new Integer[]{})) {
            findConnections(value);
        }
        return connections.size();
    }

    private static void findDirectConnections() {
        connections.addAll(programs.get(0));
    }

    private static void findConnections(int value) {
        programs.entrySet().stream().forEach(e -> {
            if (e.getValue().contains(value) && !connections.contains(e.getKey())) {
                connections.add(e.getKey());
                findConnections(e.getKey());
            }
        });
    }

    private static void mapPrograms(List<String> input) {
        for (String line : input) {
            Integer programId = Integer.valueOf(line.substring(0, line.indexOf(" ")));
            List<Integer> connectedPrograms = Arrays.stream(line.split("<->")[1].split(","))
                                                    .map(String::trim)
                                                    .map(Integer::valueOf)
                                                    .collect(Collectors.toList());
            programs.put(programId, connectedPrograms);
        }
    }
}
