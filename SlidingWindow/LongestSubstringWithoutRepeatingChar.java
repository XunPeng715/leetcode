class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) sum += num;
        return nums.length - longest(nums, sum - x);
    }
    
    public int longest(int[] nums, int target) {        
        if (target == 0) return 0;
        int res = 0, sum = 0, j = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (j <= i && sum > target) {
                sum -= nums[j];
                j++;
            }
            if (sum == target) {
                res = Math.max(i - j + 1, res);
            }
        }        
        return res == 0 ? nums.length + 1 : res;
    }
}
