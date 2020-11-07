class Solution {
    public int mctFromLeafValues(int[] arr) {
        int[][] max = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int val = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    val = Math.max(val, arr[k]);
                }
                max[i][j] = val;
            }
        }
        // int sum = dfs(arr, 0, arr.length - 1, new int[arr.length][arr.length], max);
        int sum = dp(arr, max);
        int leafSum = 0;
        for (int n : arr) leafSum += n;
        return sum - leafSum;
    }
    
    // Top-Down         time: O(n^3)    space: O(n^2)
    public int dfs(int[] arr, int start, int end, int[][] memo, int[][] max) {
        if (start == end) {
            return arr[start];
        }
        if (memo[start][end] != 0) {
            return memo[start][end];
        }
        int sum = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            sum = Math.min(sum, dfs(arr, start, i, memo, max) + dfs(arr, i + 1, end, memo, max) + max[start][i] * max[i+1][end]);
        }
        memo[start][end] = sum;
        return sum;
    }
    // Bottom-Up         time: O(n^3)    space: O(n^2)
    public int dp(int[] arr, int[][] max) {
        int[][] dp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i][i] = arr[i];
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    sum = Math.min(sum, dp[i][k] + dp[k + 1][j] + max[i][k] * max[k + 1][j]);
                }
                dp[i][j] = sum;
            }
        }
        return dp[0][arr.length - 1];
    }
}
    
    
