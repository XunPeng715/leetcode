class Solution {
    public boolean stoneGame(int[] piles) {
        int sum = 0;
        for (int pile : piles) {
            sum += pile;
        }
        // int score = dfs(piles, 0, piles.length - 1, sum, new HashMap<String, Integer>());
        int score = dp(piles);
        return score > sum - score;
    }
    // recursion      
    // time: O(2^N) space: O(N)
    public int dfs1(int[] piles, int start, int end, int sum) {
        if (start == end) {
            return piles[start];
        }
        int left = dfs1(piles, start + 1, end, sum - piles[start]);
        int right = dfs1(piles, start, end - 1, sum - piles[end]);
        int res = sum - Math.min(left, right);
        return res;
    }
    // Top-Down
    // time: O(N^2) space: O(N^2)
    public int dfs(int[] piles, int start, int end, int sum, HashMap<String, Integer> memo) {
        if (start == end) {
            return piles[start];
        }
        int[] arr = new int[]{start, end};
        String key = Arrays.toString(arr);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int left = dfs(piles, start + 1, end, sum - piles[start], memo);
        int right = dfs(piles, start, end - 1, sum - piles[end], memo);
        int res = sum - Math.min(left, right);
        memo.put(key, res);
        return res;
    }
    // Bottom-Up
    // time: O(N^2) space: O(N^2)
    public int dp(int[] piles) {
        int[] sum = new int[piles.length + 1];
        int[][] dp = new int[piles.length + 1][piles.length + 1];
        for (int i = 1; i <= piles.length; i++) {
            sum[i] = sum[i - 1] + piles[i - 1];
            dp[i][i] = piles[i - 1];
        }
        for (int i = piles.length - 1; i >= 1; i--) {
            for (int j = i + 1; j <= piles.length; j++) {
                dp[i][j] = sum[j] - sum[i - 1] - Math.min(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[1][piles.length];
    }
}
