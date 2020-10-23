class Solution {
    int count;
    public int findTargetSumWays(int[] nums, int S) {
        count = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }        
        if (sum < S || (sum - S) % 2 == 1) {
            return 0;
        }
        int target = (sum - S) / 2;        
        helper(nums, 0, target, 0);
        return count;
    }
    
    public void helper(int[] nums, int index, int target, int sum) {
        if (sum > target) {
            return;
        } else if (target == sum) {
            count++;
        }
        for (int i = index; i < nums.length; i++) {
            helper(nums, i + 1, target, sum + nums[i]);
        }
    }
}
