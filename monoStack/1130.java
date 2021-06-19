class Solution {
    public int mctFromLeafValues(int[] arr) {
        int sum = 0;
        for (int n : arr) {
            sum += n;
        }
        int[][][] memo = new int[arr.length][arr.length][3];
        int[] res = dfs(arr, 0, arr.length - 1, memo);
        return res[1] - sum;
    }
    // root, sum, maxLeaf
    public int[] dfs(int[] arr, int s, int e, int[][][] memo) {
        if (s == e) {
            return new int[]{arr[s], arr[s], arr[s]};
        }
        if (memo[s][e][1] > 0) {
            return memo[s][e];
        }
        int sum = Integer.MAX_VALUE, root = 0, maxLeaf = 0;
        for (int i = s; i < e; i++) {
            int[] left = dfs(arr, s, i, memo);
            int[] right = dfs(arr, i + 1, e, memo);
            if (left[2] * right[2] + left[1] + right[1] < sum) {
                root = left[2] * right[2];
                sum = left[2] * right[2] + left[1] + right[1];
                maxLeaf = Math.max(left[2], right[2]);
            }
        }
        memo[s][e] = new int[]{root, sum, maxLeaf};
        return memo[s][e];
    }
}
