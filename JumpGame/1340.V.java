class Solution {
    public int maxJumps(int[] arr, int d) {
        int[] memo = new int[arr.length];
        Arrays.fill(memo, -1);
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (memo[i] != -1) {
                continue;
            }
            dfs(arr, i, d, memo);
            max = Math.max(max, memo[i]);
        }
        return max;
    }
    
    public int dfs(int[] arr, int index, int d, int[] memo) {        
        int hi = arr[index];
        if (memo[index] != -1) {
            return memo[index];
        }
        int max = 1;
        for (int i = 1; i <= d; i++) {
            if (index + i >= arr.length || arr[index + i] >= hi) {
                break;
            }
            int res = dfs(arr, index + i, d, memo);
            max = Math.max(res + 1, max);
        }
        for (int i = 1; i <= d; i++) {
            if (index - i < 0 || arr[index - i] >= hi) {
                break;
            }
            int res = dfs(arr, index - i, d, memo);
            max = Math.max(res + 1, max);
        }
        memo[index] = max;
        return max;
    }
}
