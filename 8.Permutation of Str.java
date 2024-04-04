import java.util.ArrayList;
import java.util.List;

class StringPermutations {
    public static void main(String[] args) {
        String str = "abc";
        List<String> permutations = generatePermutations(str);
        for (String perm : permutations) {
            System.out.println(perm);
        }
    }

    public static List<String> generatePermutations(String str) {
        List<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            result.add("");
            return result;
        }
        char firstChar = str.charAt(0);
        String rem = str.substring(1);
        List<String> words = generatePermutations(rem);
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                sb.insert(i, firstChar);
                result.add(sb.toString());
            }
        }
        return result;
    }
}