package pl.bialorucki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationPromenade {

    public static List<Character> exchange(List<Character> input, int positionA, int positionB) {
        ArrayList<Character> result = new ArrayList<>(input);
        Character tmp = result.get(positionA);
        result.set(positionA, result.get(positionB));
        result.set(positionB, tmp);
        return result;
    }

    public static List<Character> partner(List<Character> input, Character A, Character B) {
        int indexOfA = input.indexOf(A);
        int indexOfB = input.indexOf(B);
        return exchange(input, indexOfA, indexOfB);
    }

    public static String dance(String danceMoves) {
        List<Character> input = "abcdefghijklmnop".chars()
                                                  .mapToObj(x -> (char) x)
                                                  .collect(Collectors.toList());
            for (String move : danceMoves.split(",")) {

                switch (move.charAt(0)) {
                    case 'x':
                        String[] tmp = move.substring(1).split("/");
                        int position1 = Integer.parseInt(tmp[0]);
                        int position2 = Integer.parseInt(tmp[1]);
                        Collections.swap(input, position1, position2);
                        break;
                    case 'p':
                        String[] tmp2 = move.substring(1).split("/");
                        char a = tmp2[0].toCharArray()[0];
                        char b = tmp2[1].toCharArray()[0];
                        int indexOfA = input.indexOf(a);
                        int indexOfB = input.indexOf(b);
                        Collections.swap(input, indexOfA, indexOfB);
                        break;
                    case 's':
                        int nrOfPrograms = Integer.parseInt(move.substring(1));
                        Collections.rotate(input, nrOfPrograms);
                        break;
                }
            }
        StringBuilder builder = new StringBuilder();
        input.stream().forEach(builder::append);
        return builder.toString();
    }
}
