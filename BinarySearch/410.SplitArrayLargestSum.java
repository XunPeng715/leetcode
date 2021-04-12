class Solution {
    public int splitArray(int[] nums, int m) {
        int start = 0, end = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (valid(nums, m, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    
    public boolean valid(int[] nums, int m, int max) {
        int currSum = 0;
        int countArray = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) return false;
            if (currSum + nums[i] <= max) {
                currSum += nums[i];
            } else {                
                countArray++;
                currSum = nums[i];
            }
        }
        if (currSum <= max) countArray++;
        return countArray <= m;
    }
}
