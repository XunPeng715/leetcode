class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    
    public int atMost(int[] nums, int n) {
        int count = 0;
        int j = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (j <= i && sum > n) {
                sum -= nums[j];
                j++;
            }
            count += i -  j + 1;
        }
        return count;
    }
}
