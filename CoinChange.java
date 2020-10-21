class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i] represent the fewst cost at amount i
        // dp[i] = min[dp[n - coints[0],,, dp[n - coints[i]]]] + 1
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0) {
                    continue;
                } else {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}
