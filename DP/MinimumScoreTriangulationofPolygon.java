class Solution {
    public int minScoreTriangulation(int[] A) {
        // return dfs(A, 0, A.length - 1, new HashMap<String, Integer>());
        return dp(A);
    }
    // recursion            time: O(n!)?    space: O(n)
    // Top-Down             time: O(n^3)    space: O(n^2)
    public int dfs(int[] A, int start, int end, Map<String, Integer> memo) {
        if (end == start + 1) {
            return 0;
        }
        int[] arr = new int[]{start, end};
        String key = Arrays.toString(arr);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int score = Integer.MAX_VALUE;
        for (int i = start + 1; i < end; i++) {
            score = Math.min(score, dfs(A, start, i, memo) + dfs(A, i, end, memo) + A[start] * A[end] * A[i]);
        }
        memo.put(key, score);
        return score;
    }
    // Bottom-Up             time: O(n^3)    space: O(n^2)
    public int dp(int[] A) {
        int[][] dp = new int[A.length][A.length];
        for (int i = A.length - 2; i >= 0; i--) {
            for (int j = i + 2; j < A.length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[j] * A[k]);
                }
            }
        }
        return dp[0][A.length - 1];
    }
}
