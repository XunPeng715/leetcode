class Solution {
    int MOD = 1000000007;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        long[] pows = new long[nums.length];
        pows[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pows[i] = pows[i - 1] * 2 % MOD;
        }
        long count = 0;
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else {
                // choose any from [i + 1, j]
                count = (count + pows[j - i]) % MOD;
                i++;
            }
        }
        return (int) count;
    }
}
