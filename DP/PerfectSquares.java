class Solution {
    public int numSquares(int n) {
        int[][] memo = new int[n + 1][];
        for (int i = 0; i < n + 1; i++) {
            memo[i] = new int[(int) Math.sqrt(n) + 1];
            Arrays.fill(memo[i], -1);
        }
        return dfs(n, (int) Math.sqrt(n), memo);
    }
    
    public int dfs(int n, int root, int[][] memo) {
        if (n == 0) {
            return 0;
        }
        if (memo[n][root] != -1) {
            return memo[n][root];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= root; i++) {
            res = Math.min(res, dfs(n - i * i, Math.min((int) Math.sqrt(n - i * i), i), memo));
        }
        memo[n][root] = res + 1;
        return res + 1;
    }
}
