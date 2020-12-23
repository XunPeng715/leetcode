class Solution {
    public int splitArray(int[] nums, int m) {
        int[][] memo = new int[nums.length][];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = new int[m + 1];
            Arrays.fill(memo[i], -1);
        }
        return dfs(nums, 0, m, memo);
    }
    
    public int dfs(int[] nums, int i, int m, int[][] memo) {
        int sum = 0;
        if (m == 1) {
            for (int j = i; j < nums.length; j++) sum += nums[j];
            return sum;
        }        
        if (i == nums.length) {
            return Integer.MAX_VALUE;
        }
        if (memo[i][m] != -1) {
            return memo[i][m];
        }
        int res = Integer.MAX_VALUE;
        for (int j = i + 1; j <= nums.length - 1; j++) {
            sum += nums[j - 1];
            res = Math.min(res, Math.max(sum, dfs(nums, j, m - 1, memo)));
        }
        memo[i][m] = res;
        return res;
    }
}
