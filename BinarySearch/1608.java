class Solution {
    public int specialArray(int[] nums) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            // >= mid
            int count = check(nums, mid);
            if (count >= mid) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        if (check(nums, l) == l) {
            return l;
        }
        return -1;
    }
    
    public int check(int[] nums, int x) {
        int count = 0;
        for (int num : nums) {
            if (num >= x) {
                count++;
            }
        }
        return count;
    }
}
