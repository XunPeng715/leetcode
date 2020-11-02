class Solution {
    public boolean winnerSquareGame(int n) {
        // return dfs1(n, new HashMap<Integer, Boolean>());
        return dp(n);
    }
    // recursion         time: O(n^(n/2))       space: O(n)
    public boolean dfs(int n) {
        if (n == 0) {
            return false;
        }
        int max = (int) Math.sqrt(n);
        boolean otherWin = true;
        for (int i = 1; i <= max; i++) {
            otherWin = otherWin && dfs(n - i * i);
        }
        return !otherWin;
    }
    // Top-Down         time: O(n^1.5)   space: O(n)
    public boolean dfs1(int n, Map<Integer, Boolean> memo) {
        if (n == 0) {
            return false;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int max = (int) Math.sqrt(n);
        boolean win = false;
        for (int i = 1; i <= max; i++) {
            if (dfs1(n - i * i, memo) == false) {
                win = true;
                break;
            }
        }
        memo.put(n, win);
        return win;
    }
    // Bottom-Up        time: O(n^1.5)   space: O(n)
    public boolean dp(int n) {
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            int max = (int) Math.sqrt(i);
            for (int j = 1; j <= max; j++) {
                if (dp[i - j * j] == false) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
