class Solution {
    public int lastStoneWeightII(int[] stones) {
        // n / 2 --> target = Sum / 2
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        // dp[i][j] = Max(dp[i-1][j], dp[i-1][j-stones[i-1]] + stones[i-1]) if both <= target
        int[] dp = new int[target + 1];
        for (int i = 1; i <= stones.length; i++) {
            for (int j = target; j > 0; j--) {
                if (j - stones[i - 1] >= 0 && dp[j - stones[i-1]] <= target - stones[i-1]) {
                    dp[j] = Math.max(dp[j], dp[j - stones[i-1]] + stones[i-1]);
                }
            }
        }
        return sum - dp[target] * 2;
    }
}
