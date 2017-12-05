package pl.bialorucki;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * --- Day 4: High-Entropy Passphrases ---
 */
public class HighEntropyPassphrases {
    public static boolean check(String passphrase) {
        String[] splittedPassphrase = passphrase.split(" ");
        Map<String, Long> collectedElements = Arrays.stream(splittedPassphrase)
                                                    .collect(Collectors
                                                            .groupingBy(x -> x, Collectors.counting()));
        return !collectedElements.values().stream().anyMatch(x -> x > 1);

    }

    public static boolean checkUsingAnagramDetection(String passphrase) {
        String[] splittedPassphrase = passphrase.split(" ");
        for (int i = 0; i < splittedPassphrase.length - 1; i++) {
            for(int j = i + 1 ; j < splittedPassphrase.length ; j++) {
                if (isAnagram(splittedPassphrase[i], splittedPassphrase[j])) {
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean isAnagram(String firstString, String secondString) {
        if (firstString.length() != secondString.length())
            return false;
        char[] firstArray = firstString.toCharArray();
        char[] secondArray = secondString.toCharArray();

        Arrays.sort(firstArray);
        Arrays.sort(secondArray);
        return Arrays.equals(firstArray, secondArray);
    }
}
