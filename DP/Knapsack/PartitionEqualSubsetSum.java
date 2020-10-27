class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= 1; j--) {
                if (j >= nums[i - 1]) {
                    dp[j] = dp[j] || dp[j - nums[i - 1]];
                }
            }
        }
        return dp[target];
    }
}
