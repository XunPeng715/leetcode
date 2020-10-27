class Solution {
    class Pair {
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public boolean PredictTheWinner(int[] nums) {
        Pair[][] dp = new Pair[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = new Pair(nums[i], 0);
        }
        for (int d = 1; d < nums.length; d++) {
            for (int j = d; j < nums.length; j++) {
                int i = j - d;
                // get num from left
                if (dp[i + 1][j].second + nums[i] > dp[i][j - 1].second + nums[j]) {
                    dp[i][j] = new Pair(dp[i + 1][j].second + nums[i], dp[i + 1][j].first);
                } else {
                    dp[i][j] = new Pair(dp[i][j - 1].second + nums[j], dp[i][j - 1].first);
                }
            }
        }
        return dp[0][nums.length - 1].first >= dp[0][nums.length - 1].second;
    }
}
