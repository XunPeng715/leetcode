class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int sum = 0;
        for (int val : stoneValue) sum += val;
        // int score = dfs(stoneValue, 0, stoneValue.length - 1, sum, new HashMap<Integer, Integer>());
        int score = dp(stoneValue);
        if (sum - score < score) {
            return "Alice";
        } else if (sum - score > score) {
            return "Bob";
        }
        return "Tie";
    }
    // recursion            time: O(3^n)         space: O(n)
    // Top-Down             time: O(3n) -> O(n)  space: O(n)
    public int dfs(int[] stoneValue, int start, int end, int sum, Map<Integer, Integer> memo) {
        if (start == end) {
            return sum;
        }
        if (memo.containsKey(start)) {
            return memo.get(start);
        }
        int preSum = 0;
        int otherScore = Integer.MAX_VALUE;
        for (int i = 1; i <= 3; i++) {
            if (start + i > end) {
                otherScore = Math.min(otherScore, 0);
            } else {
                preSum += stoneValue[start + i - 1];
                otherScore = Math.min(otherScore, dfs(stoneValue, start + i, end, sum - preSum, memo));
            }            
        }
        memo.put(start, sum - otherScore);
        return sum - otherScore;
    }
    // Bottom-Up             time: O(n)          space: O(n) this could continue to be optimized to O(1)
    public int dp(int[] stoneValue) {
        int[] dp = new int[stoneValue.length + 1];        
        int[] postSum = new int[stoneValue.length + 1];
        dp[stoneValue.length] = stoneValue[stoneValue.length - 1];
        int sum = 0;
        for (int i = stoneValue.length; i > 0; i--) {
            sum += stoneValue[i - 1];
            postSum[i] = sum;
            int otherScore = Integer.MAX_VALUE;
            for (int j = 1; j <= 3; j++) {
                if (j + i > stoneValue.length) {
                    otherScore = Math.min(otherScore, 0);
                } else {
                    otherScore = Math.min(otherScore, dp[i + j]);
                }                
            }
            dp[i] = postSum[i] - otherScore;
        }
        return dp[1];
    }
}
