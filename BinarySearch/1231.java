class Solution {
    public int maximizeSweetness(int[] sweetness, int K) {
        // find the last candidate
        int l = 1, r = Integer.MAX_VALUE;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (valid(sweetness, K, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    
    public boolean valid(int[] sweetness, int K, int min) {
        int count = 0, prevSweet = 0;
        for (int sweet : sweetness) {
            prevSweet += sweet;
            if (prevSweet >= min) {
                prevSweet = 0;
                count++;
            }
        }
        return count >= K + 1;
    }
}
