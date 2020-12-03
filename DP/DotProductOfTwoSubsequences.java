class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] memo = new int[nums1.length][];
        for (int i = 0; i < nums1.length; i++) {
            memo[i] = new int[nums2.length];
            Arrays.fill(memo[i], -1);
        }        
        return dfs(nums1, 0, nums2, 0, memo);
    }
    // 注意为什么用 integer.MIN_VALUE
    // 为什么用 Math.max(0, dfs(nums1, i + 1, nums2, j + 1, memo)) + nums1[i] * nums2[j] 
    // 而不是 Math.max(0, nums1[i] * nums2[j]) + dfs(nums1, i + 1, nums2, j + 1, memo)
    public int dfs(int[] nums1, int i, int[] nums2, int j, int[][] memo) {
        if (i == nums1.length || j == nums2.length) return Integer.MIN_VALUE;
        if (memo[i][j] != -1) {
            return memo[i][j];
        }   
        memo[i][j] = Math.max(Math.max(dfs(nums1, i + 1, nums2, j, memo), dfs(nums1, i, nums2, j + 1, memo)), 
                               Math.max(0, dfs(nums1, i + 1, nums2, j + 1, memo)) + nums1[i] * nums2[j]);
        
        return memo[i][j];
    } 
}
