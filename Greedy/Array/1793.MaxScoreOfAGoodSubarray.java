class Solution {
    public int maximumScore(int[] nums, int k) {
        int min = nums[k];
        int i = k, j = k;
        int max = nums[k];
        while (i >= 0 || j < nums.length) {
            if (i == 0 && j == nums.length - 1) break;
            if (i == 0) {
                j++;
                min = Math.min(nums[j], min);                
            } else if (j == nums.length - 1) {
                i--;
                min = Math.min(nums[i], min);                
            } else if (nums[i - 1] >= nums[j + 1]) {
                i--;
                min = Math.min(nums[i], min);     
            } else if (nums[i - 1] < nums[j + 1]) {
                j++;
                min = Math.min(nums[j], min);  
            }
            max = Math.max(max, min * (j - i + 1));
        }
        return max;
    }
}
