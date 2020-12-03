class Solution {
    public int minInsertions(String s) {
        int[][] memo = new int[s.length()][];
        for (int i = 0; i < s.length(); i++) {
            memo[i] = new int[s.length()];
            Arrays.fill(memo[i], -1);
        }
        return dfs(s, 0, s.length() - 1, memo);
    }
    
    public int dfs(String s, int i, int j, int[][] memo) {
        if (i >= j) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        if (s.charAt(i) == s.charAt(j)) memo[i][j] = dfs(s, i + 1, j - 1, memo);
        else memo[i][j] = Math.min(dfs(s, i + 1, j, memo), dfs(s, i, j - 1, memo)) + 1;
        return memo[i][j];
    }
}
