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
}
