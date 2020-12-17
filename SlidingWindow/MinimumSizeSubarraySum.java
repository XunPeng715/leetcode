class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (j <= i && sum >= s) {
                min = Math.min(min, i - j + 1);
                sum -= nums[j];
                j++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
