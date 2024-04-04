public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int n = nums.length;
    int minDiff = Integer.MAX_VALUE;
    int closestSum = 0;
    for (int i = 0; i < n; i++) {
        int left = i + 1;
        int right = n - 1;
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            int diff = Math.abs(sum - target);
            if (diff < minDiff) {
                minDiff = diff;
                closestSum = sum;
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
    return closestSum;
}