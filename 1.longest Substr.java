import java.util.HashMap;

public class LengthOfLongestSubstring {
    public String lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int ansStart = 0, ansEnd = 0, start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(map.get(s.charAt(i)), start);
            }
            map.put(s.charAt(i), i + 1);
            if (i - start + 1 > ansEnd - ansStart) {
                ansStart = start;
                ansEnd = i + 1;
            }
        }
        return s.substring(ansStart, ansEnd);
    }
}