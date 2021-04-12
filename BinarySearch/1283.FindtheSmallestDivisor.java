class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1, end = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (check(nums, mid, threshold)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    
    public boolean check(int[] nums, int min, int threshold) {
        int res = 0;
        for (int num : nums) {
            res += (num + min - 1) / min;
        }
        return res <= threshold;
    }
}
