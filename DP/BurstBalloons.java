class Solution {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        arr[0] = 1;
        arr[nums.length + 1] = 1;
        for (int i = 0; i < nums.length; i++) arr[i + 1] = nums[i];        
        // return dfs(arr, 0, nums.length + 1, new HashMap<String, Integer>());
        return dp(arr);
    }
    // recursion            time: O(n!)     space: O(n)
    // Top-Down             time: O(n^3)    space: O(n^2)
    public int dfs(int[] arr, int start, int end, Map<String, Integer> memo) {
        if (start + 1 == end) {
            return 0;
        }
        int[] pair = new int[]{start, end};
        String key = Arrays.toString(pair);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int score = Integer.MIN_VALUE;
        for (int i = start + 1; i < end; i++) {
            score = Math.max(score, dfs(arr, start, i, memo) + dfs(arr, i, end, memo) + arr[start] * arr[end] * arr[i]);
        }
        memo.put(key, score);
        return score;
    }
    // Bottom-Up            time: O(n^3)    space: O(n^2)
    public int dp(int[] arr) {        
        int[][] dp = new int[arr.length][arr.length];
        for (int i = arr.length - 3; i >= 0; i--) {
            for (int j = i + 2; j < arr.length; j++) {
                int score = Integer.MIN_VALUE;
                for (int k = i + 1; k < j; k++) {
                    score = Math.max(score, dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j]);
                }
                dp[i][j] = score;
            }
        }
        return dp[0][arr.length - 1];
    }
}
