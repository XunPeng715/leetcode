class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[][] memo = new int[n + 1][n + 1];
        for (int[] row: memo) Arrays.fill(row, -1);
        // return dfs(0, n, cuts, 0, cuts.length - 1, memo);
        // return dp(n, cuts);
        return dfs1(0, n, cuts, memo);
    }
    
    public int dfs1(int start, int end, int[] cuts, int[][] memo) {
        boolean couldCut = false;
        int cost = Integer.MAX_VALUE;
        if (memo[start][end] != -1) {
            return memo[start][end];
        }
        for (int cut : cuts) {
            if (cut > start && cut < end) {
                couldCut = true;
                cost = Math.min(cost, dfs1(start, cut, cuts, memo) + dfs1(cut, end, cuts, memo) + end - start);
            }
        }
        if (!couldCut) {
            return 0;
        }
        memo[start][end] = cost;
        return memo[start][end];
    }
    
    // Top-Down         time: O(n^3)    space: O(n^2)
    public int dfs(int start, int end, int[] cuts, int leftCut, int rightCut, int[][] memo) {
        if (leftCut > rightCut) {
            return 0;
        }
        if (memo[leftCut][rightCut] != -1) {
            return memo[leftCut][rightCut];
        }
        int cost = Integer.MAX_VALUE;
        for (int i = leftCut; i <= rightCut; i++) {
            int leftCost = dfs(start, cuts[i], cuts, leftCut, i - 1, memo);
            int rightCost = dfs(cuts[i], end, cuts, i + 1, rightCut, memo);
            cost = Math.min(cost, end - start + leftCost + rightCost);
        }
        memo[leftCut][rightCut] = cost;
        return cost;
    }
    // Bottom-Up         time: O(n^3)    space: O(n^2)
    public int dp(int n, int[] cuts) {
        int[] tmp = new int[cuts.length + 2];
        tmp[0] = 0;
        tmp[cuts.length + 1] = n;
        for (int i = 0; i < cuts.length; i++) tmp[i + 1] = cuts[i];
        cuts = tmp;
        int[][] dp = new int[cuts.length][cuts.length];
        for (int i = cuts.length - 3; i >= 0; i--) {
            for (int j = i + 2; j < cuts.length; j++) {
                int cost = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    cost = Math.min(cost, dp[i][k] + dp[k][j] + cuts[j] - cuts[i]); 
                }
                dp[i][j] = cost;
            }
        }
        return dp[0][cuts.length - 1];
    }
}
