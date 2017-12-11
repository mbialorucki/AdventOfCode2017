package pl.bialorucki;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<String> readFileContent(String fileName) {
        List<String> fileContent = new ArrayList<>();
        try {
            fileContent = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return fileContent;
    }

}