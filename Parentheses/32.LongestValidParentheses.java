class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length() + 1];
        int res = 0;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                if (s.charAt(i + 1) == ')') {
                    dp[i] = 2 + dp[i + 2];
                } else if (i + dp[i + 1] + 1 < s.length() && s.charAt(i + dp[i + 1] + 1) == ')') {
                    dp[i] = 2 + dp[i + 1] + dp[i + dp[i + 1] + 2];
                }                
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
