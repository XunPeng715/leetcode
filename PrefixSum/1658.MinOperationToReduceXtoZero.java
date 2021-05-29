class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum - x, max = -1, curr = 0, j = 0;
        for (int i = 0; i < nums.length; i++) {
            curr += nums[i];
            while (j <= i && curr > target) {
                curr -= nums[j];
                j++;
            }
            if (curr == target) {
                max = Math.max(max, i - j + 1);
            }
        }
        int res = nums.length - max;
        return res > nums.length ? -1 : res;
    }
}
