class Solution {
    public int rob(int[] nums) {
        // return dfs(nums, 0, new HashMap<Integer, Integer>());
        return dp(nums);
    }
    // recursion        time: O(2^(n/2))  space: O(n/2)
    // Top-Down         time: O(n)        space: O(n)
    public int dfs(int[] nums, int start, Map<Integer, Integer> memo) {
        if (start >= nums.length) {
            return 0;
        }
        if (memo.containsKey(start)) {
            return memo.get(start);
        }
        int num1 = 0;
        int num2 = 0;
        if (start < nums.length) {
            num1 = dfs(nums, start + 2, memo) + nums[start];
        }
        if (start + 1 < nums.length) {
            num2 = dfs(nums, start + 3, memo) + nums[start + 1];
        }
        memo.put(start, Math.max(num1, num2));
        return memo.get(start);
    }
    // Bottom-Up        time: O(n)        space: O(n)
    public int dp(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            int num1 = (i + 2 < nums.length) ? dp[i + 2] : 0;
            int num2 = (i + 3 < nums.length) ? dp[i + 3] : 0;
            dp[i] = Math.max(nums[i] + num1, nums[i + 1] + num2);
        }
        return dp[0];
    }
}
