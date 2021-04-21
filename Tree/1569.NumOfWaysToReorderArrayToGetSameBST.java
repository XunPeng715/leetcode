class Solution {
    int MOD = 1000000007;
    long[][] table;
    public int numOfWays(int[] nums) {
        table = new long[nums.length][nums.length];
        for (int i = 1; i < nums.length; i++) {            
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    table[i][j] = 1;
                } else if (j == 1) {
                    table[i][j] = i;
                } else {
                    table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % MOD;
                }                
            }
        }
        long[][] tmp = table;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        return (int) dfs(list) - 1;
    }
    
    public long dfs(List<Integer> nums) {
        if (nums.size() == 0 || nums.size() == 1) return nums.size();
        
        List<Integer> leftNums = new ArrayList<>();
        List<Integer> rightNums = new ArrayList<>();
        for (int n = 1; n < nums.size(); n++) {
            if (nums.get(n) > nums.get(0)) {
                rightNums.add(nums.get(n));
            } else {
                leftNums.add(nums.get(n));
            }
        }
        long left = dfs(leftNums);
        long right = dfs(rightNums);
        if (left == 0) {
            return right;
        } else if (right == 0) {
            return left;
        }
        return (((left * right) % MOD) * table[nums.size() - 1][leftNums.size()]) % MOD;
        // left * right * C(leftLength, N - 1)
    }
}
