import java.util.HashMap;

public class Main {
    
    class Solution {
    public int maxSum(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int incl = nums[0];
        int excl = 0;
        int excl_new;
        for (int i = 1; i < n; i++) {
            excl_new = Math.max(incl, excl);
            incl = excl + nums[i];
            excl = excl_new;
        }
        return Math.max(incl, excl);
    
}