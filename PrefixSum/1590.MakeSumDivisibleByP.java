class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int[] prevSum = new int[n + 1];
        prevSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            prevSum[i] = (nums[i - 1] + prevSum[i - 1]) % p;
        }
        int req = prevSum[n], min = n;
        if (req == 0) {
            return 0;
        }
        Map<Integer, Integer> lastOcur = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            int lastNum = (prevSum[i] + p - req) % p;
            if (lastOcur.containsKey(lastNum)) {
                min = Math.min(min, i - lastOcur.get(lastNum));
            }
            lastOcur.put(prevSum[i], i);
        }
        if (min == n) {
            return -1;
        }
        return min;
    }
}
