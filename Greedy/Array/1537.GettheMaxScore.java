class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        Map<Integer, Long> sum1 = new HashMap<>();
        Map<Integer, Long> sum2 = new HashMap<>();
        long sum = (long) 0;
        for (int num : nums1) {
            sum = (long) sum + num;
            sum1.put(num, sum);
        }
        sum = (long) 0;
        for (int num : nums2) {
            sum = (long) sum + num;
            sum2.put(num, sum);
        }
        Long res = (long) 0;
        int prev = -1, MOD = 1000000007;
        sum1.put(prev, res);
        sum2.put(prev, res);
        for (int i = 0; i < nums1.length; i++) {
            int curr = nums1[i];
            if (sum2.containsKey(curr)) {
                if (prev == -1) {
                    res = Math.max(sum1.get(curr), sum2.get(curr)) + res;
                } else {
                    res = Math.max(sum1.get(curr) - sum1.get(prev), sum2.get(curr) - sum2.get(prev)) + res;
                }
                prev = curr;
            }
        }
        return (int) ((Math.max(sum1.get(nums1[nums1.length - 1]) - sum1.get(prev), sum2.get(nums2[nums2.length - 1]) - sum2.get(prev)) + res) % MOD);
    }
}
