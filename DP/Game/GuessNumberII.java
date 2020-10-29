class Solution {
    public int getMoneyAmount(int n) {
        // return dfs(n, 0, n, new HashMap<String, Integer>());
        return dp(n);
    }
    // recursion
    // time: O(n!) space: O(n)
    public int dfs1(int n, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int min = Integer.MAX_VALUE;        
        for (int i = start; i <= end; i++) {
            int cost1 = dfs1(n, start, i - 1);
            int cost2 = dfs1(n, i + 1, end);
            min = Math.min(min, Math.max(cost1, cost2) + i);
        }
        return min;
    }

    // Top-Down recursion + memo
    // time: O(n^2)  space: O(n^2)
    public int dfs(int n, int start, int end, Map<String, Integer> memo) {
        if (start >= end) {
            return 0;
        }
        int[] arr = new int[]{start, end};
        String key = Arrays.toString(arr);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int min = Integer.MAX_VALUE;        
        for (int i = start; i <= end; i++) {
            int cost1 = dfs(n, start, i - 1, memo);
            int cost2 = dfs(n, i + 1, end, memo);
            min = Math.min(min, Math.max(cost1, cost2) + i);
        }
        memo.put(key, min);
        return min;
    }
    // Bottom-Up
    // time: O(n^2)  space: O(n^2)
    public int dp(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i > 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    if (k == i) min = Math.min(min, k + dp[k + 1][j]);
                    else if (k == j) min = Math.min(min, dp[i][k - 1] + k);
                    else min = Math.min(min, Math.max(dp[i][k - 1],dp[k + 1][j]) + k);
                    dp[i][j] = min;
                }
            }
        }
        return dp[1][n];
    }
}
