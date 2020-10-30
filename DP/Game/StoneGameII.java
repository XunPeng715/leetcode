class Solution {
    public int stoneGameII(int[] piles) {
        int sum = 0;
        for (int pile : piles) sum += pile;
        // return dfs1(piles, 1, 0, piles.length - 1, sum, new HashMap<>());
        return dp(piles);
    }    
    // recursion     time: O(2^n)  space O(n)
    // Top-Down      time: O(n^2)  space O(n^2)
    public int dfs1(int[] piles, int M, int start, int end, int sum, HashMap<String, Integer> memo) {
        if (M * 2 > end - start) {
            return sum;
        }
        int[] arr = new int[]{M, start};
        String key = Arrays.toString(arr);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int prevSum = 0;
        int otherScore = Integer.MAX_VALUE;
        for (int x = 1; x <= M * 2; x++) {
            prevSum += piles[start + x - 1];
            otherScore = Math.min(otherScore, dfs1(piles, Math.max(M, x), start + x, end, sum - prevSum, memo));          
        }
        memo.put(key, sum - otherScore);
        return sum - otherScore;
    }
    // Top-Down      time: O(?)  space O(n^2)
    public int dp(int[] piles) {
        int[] postSum = new int[piles.length];
        int sum = 0;
        for (int i = piles.length - 1; i >= 0; i--) {
            sum += piles[i];
            postSum[i] = sum;
        }
        int[][] dp = new int[piles.length + 1][piles.length + 1];
        for (int i = 1; i <= piles.length; i++) {
            dp[i][piles.length] = piles[piles.length - 1];
        }
        for (int j = piles.length - 1; j > 0; j--) {
            for (int M = 1; M <= piles.length; M++) {
                int otherScore = Integer.MAX_VALUE;
                for (int x = 1; x <= M * 2; x++) {
                    if (x + j > piles.length) {
                        otherScore = 0;
                        break;
                    }
                    otherScore = Math.min(otherScore, dp[Math.max(M, x)][j + x]);
                }
                dp[M][j] = postSum[j - 1] - otherScore;
            }
        }
        return dp[1][1];
    }
}
