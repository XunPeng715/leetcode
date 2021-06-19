class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int l = 0, r = maxSum;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (valid(n, index, mid, maxSum)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    
    public boolean valid(int n, int index, int hi, int maxSum) {
        long sum = 0;
        if (hi > index) {
            sum += (long) (2 * hi - index) * (index + 1) / 2;            
        } else {
            sum += (long) (hi + 1) * hi / 2;
            sum += (long) index + 1 - hi;
        }
        if (hi > n - index - 1) {
            sum += (long) (2 * hi + index - n + 1) * (n - index) / 2;            
        } else {
            sum += (long) (hi + 1) * hi / 2;
            sum += (long) n - index - hi;
        }
        return sum - hi <= (long) maxSum;
    }
}
