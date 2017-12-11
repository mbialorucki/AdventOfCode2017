package pl.bialorucki;

import java.util.List;
import java.util.Stack;

/**
 * --- Day 9: Stream Processing ---
 */
public class StreamProcessing {

    private static final String GARBAGE_REGEX = "<.*?>";
    private static final String GROUP_REGEX = "[^{}]";
    private static final String CANCEL_REGEX = "!.";

    public static int countGroups(String fileName) {
        List<String> input = Utils.readFileContent(fileName);
        String line = input.get(0);
        String cleanLine = line.replaceAll(CANCEL_REGEX, "")
                               .replaceAll(GARBAGE_REGEX, "")
                               .replaceAll(GROUP_REGEX, "");
        Stack<Character> stack = new Stack<>();
        int count = 0;
        int depth = 1;

        for (Character ch : cleanLine.toCharArray()) {
            switch (ch) {
                case '{':
                    stack.push(ch);
                    depth++;
                    break;
                case '}':
                    stack.pop();
                    depth--;
                    count += depth;
                    break;
            }
        }
        return count;
    }

}
