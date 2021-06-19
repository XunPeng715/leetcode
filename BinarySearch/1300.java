class Solution {
    public int findBestValue(int[] arr, int target) {
        int max = 0;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        int l = 0, r = max;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            int sum = helper(arr, mid);
            if (sum > target) {
                r = mid;
            } else if (sum < target) {
                l = mid;
            } else {
                return mid;
            }
        }
        if (Math.abs(helper(arr, l) - target) <= Math.abs(helper(arr, r) - target)) {
            return l;
        }
        return r;
    }
    
    public int helper(int[] arr, int val) {
        int sum = 0;
        for (int num : arr) {
            if (num > val) {
                sum += val;
            } else {
                sum += num;
            }
        }
        return sum;
    }
}
