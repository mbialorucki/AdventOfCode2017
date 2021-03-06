package pl.bialorucki;

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
    private static int max;

    public static int[] findMaxRegisterValue(String fileName) {
        registers = new HashMap<>();
        fileContent = Utils.readFileContent(fileName);
        initializeRegisters();
        max = 0;

        for (String line : fileContent) {
            processLine(line);
        }
        return new int[]{registers.values().stream().max(Comparator.naturalOrder()).get(),max};
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

        if(registers.get(register) > max){
            max = registers.get(register);
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


}
