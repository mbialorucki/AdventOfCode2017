package pl.bialorucki;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * --- Day 8: I Heard You Like Registers ---
 */
public class Registers {

    private static Map<String, Integer> registers;
    private static List<String> fileContent;

    public static int findMaxRegisterValue(String fileName) {
        registers = new HashMap<>();
        readFileContent(fileName);
        initializeRegisters();
        for (String line : fileContent) {
            processLine(line);
        }
        return registers.values().stream().max(Comparator.naturalOrder()).get();
    }

    private static void processLine(String line) {
        String[] splittedLine = line.split(" ");

        String register = splittedLine[0];
        String operation = splittedLine[1];
        String operationValue = splittedLine[2];
        String registerToCheck = splittedLine[4];
        String condition = splittedLine[5];
        String conditionValue = splittedLine[6];

        if (checkCondition(registerToCheck, condition, conditionValue)) {
            modifyRegister(register,operation,operationValue);
        }
    }

    private static void modifyRegister(String register, String operation, String operationValue) {
        switch (operation){
            case "inc":
                registers.put(register,registers.get(register)+Integer.parseInt(operationValue));
                break;
            case "dec":
                registers.put(register,registers.get(register)-Integer.parseInt(operationValue));
                break;
        }
    }

    private static boolean checkCondition(String registerToCheck, String condition, String conditionValue) {
        int valueToCheck = Integer.parseInt(conditionValue);
        int registerValue = registers.get(registerToCheck);

        switch (condition) {
            case "<":
                return registerValue < valueToCheck;
            case ">":
                return registerValue > valueToCheck;
            case "==":
                return registerValue == valueToCheck;
            case "<=":
                return registerValue <= valueToCheck;
            case ">=":
                return registerValue >= valueToCheck;
            case "!=":
                return registerValue != valueToCheck;
        }
        return false;
    }

    private static void initializeRegisters() {
        for (String line : fileContent) {
            String register = line.substring(0, line.indexOf(" "));
            registers.put(register, 0);
        }
    }

    private static void readFileContent(String fileName) {
        try {
            fileContent = Files.readAllLines(Paths.get(fileName));

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }


}
