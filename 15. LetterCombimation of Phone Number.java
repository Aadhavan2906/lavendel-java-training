import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    private static final Map<Character, char[]> KEYPAD = new HashMap<>();

    static {
        KEYPAD.put('2', new char[]{'a', 'b', 'c'});
        KEYPAD.put('3', new char[]{'d', 'e', 'f'});
        KEYPAD.put('4', new char[]{'g', 'h', 'i'});
        KEYPAD.put('5', new char[]{'j', 'k', 'l'});
        KEYPAD.put('6', new char[]{'m', 'n', 'o'});
        KEYPAD.put('7', new char[]{'p', 'q', 'r', 's'});
        KEYPAD.put('8', new char[]{'t', 'u', 'v'});
        KEYPAD.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }

        StringBuilder sb = new StringBuilder();
        helper(digits, 0, sb);

        return result;
    }

    private void helper(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        char[] chars = KEYPAD.get(digits.charAt(index));
        for (char c : chars) {
            sb.append(c);
            helper(digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}