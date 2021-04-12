class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int start = weights[0], end = Integer.MAX_VALUE;
        for (int w : weights) {
            if (w > start)
                start = w;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (check(mid, weights, D)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    
    public boolean check(int cap, int[] weights, int D) {
        int d = 1, curr = 0;
        for (int w : weights) {
            if (w + curr > cap) {
                d++;
                curr = w;
            } else {
                curr += w;
            }
        }
        
        return d <= D;
    }
}
