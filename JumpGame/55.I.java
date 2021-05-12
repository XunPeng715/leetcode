class Solution {
    public boolean canJump(int[] nums) {
        int left = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= left) {
                left = i;
            }
        }
        return left == 0;
    }
}
