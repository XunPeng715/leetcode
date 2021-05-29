class Solution {
    public int getMaxLen(int[] nums) {        
        int start = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Math.max(max, helper(nums, start, i - 1));
                start = i + 1;
            }
        }
        max = Math.max(max, helper(nums, start, nums.length - 1));
        return max;
    }
    
    public int helper(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }
        int[] tmp = new int[end - start + 2];
        tmp[0] = 1;
        int firstPos = start - 1, firstNeg = -1, res = 0;
        for (int i = start; i <= end; i++) {
            tmp[i - start + 1] = nums[i] * (tmp[i - start] / Math.abs(tmp[i - start]));
            if (tmp[i - start + 1] < 0 && firstNeg == -1) {
                firstNeg = i;
            }
            if (tmp[i - start + 1] < 0) {
                res = Math.max(res, i - firstNeg);
            }
            if (tmp[i - start + 1]> 0) {
                res = Math.max(res, i - firstPos);
            }
        }
        return res;
    }
}
