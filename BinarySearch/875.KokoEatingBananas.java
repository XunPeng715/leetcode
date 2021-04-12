class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1, end = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (check(piles, h, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    
    public boolean check(int[] piles, int h, int k) {
        int H = 0;
        for (int pile : piles) {
            if (pile % k == 0) {
                H += pile / k;
            } else {
                H += pile / k + 1;
            }
        }
        return H <= h;
    }
}›
