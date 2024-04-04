public int maxSubArraySum(int[] nums, int left, int right) {
    int maxSum = Integer.MIN_VALUE;
    for (int i = left; i <= right; i++) {
        int sum = 0;
        for (int j = i; j <= right; j++) {
            sum += nums[j];
            maxSum = Math.max(maxSum, sum);
        }
    }
    return maxSum;
}