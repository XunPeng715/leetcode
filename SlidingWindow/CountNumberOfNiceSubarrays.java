class Solution {
    // Solution: sliding windows
    public int numberOfSubarrays1(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    
    public int atMost(int[] nums, int k) {
        int j = 0, count = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) count++;
            while (j <= i && count > k) {
                if (nums[j] % 2 == 1) count--;
                j++;
            }
            res += i - j;
        }
        return res;
    }
    // Solution: preSum
    public int numberOfSubarrays(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];
        int[] counts = new int[nums.length + 1];
        preSum[0] = 0;
        counts[0] = 1;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i] % 2;
            counts[preSum[i + 1]]++;
            if (preSum[i + 1] - k >= 0) {
                res += counts[preSum[i + 1] - k];
            }            
        }
        return res;
    }
}
