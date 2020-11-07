class Solution {
    public int strangePrinter(String s) {
        int[][] memo = new int[s.length()][s.length()];
        return dfs(s, 0, s.length() - 1, memo);
    }
    // Top-Down             time: O(n^3)    space: O(n^2)
    public int dfs(String s, int start, int end, int[][] memo) {
        if (start > end) return 0;
        if (start == end) return 1;
        if (start + 1 == end) return (s.charAt(start) == s.charAt(end)) ? 1 : 2;
        if (memo[start][end] != 0) {
            return memo[start][end];
        }
        int turns = Integer.MAX_VALUE;
        for (int k = start; k < end; k++) {1    111111
            int leftTurns = dfs(s, start, k, memo);
            int rightTurns = dfs(s, k + 1, end, memo);
            if (s.charAt(k) == s.charAt(end)) {
                turns = Math.min(turns, leftTurns + rightTurns - 1);
            } else {
                turns = Math.min(turns, leftTurns + rightTurns);
            }
        }
        memo[start][end] = turns;
        return turns;
    }
}
