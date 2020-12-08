class Solution {
    public boolean makesquare(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 4 != 0) return false;
        return dfs(nums, 0, sum / 4, 0, 0);
    }
    
    public boolean dfs(int[] nums, int count, int edge, int curr, int start) {
        if (curr == edge) {
            curr = 0;
            count++;
            start = 0;
        }
        if (count == 4) return true;
        for (int i = start; i < nums.length; i++) {
            if (nums[i] == 0 || nums[i] + curr > edge) continue;
            int tmp = nums[i];
            nums[i] = 0;
            if (dfs(nums, count, edge, curr + tmp, i + 1)) return true;
            nums[i] = tmp;
        }
        return false;
    }
}
