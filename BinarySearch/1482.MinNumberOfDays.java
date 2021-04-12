class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }
        int start = 1, end = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (check(bloomDay, m, k, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    
    public boolean check(int[] bloomDay, int m, int k, int min) {        
        int start = -1;
        int count = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            int date = bloomDay[i];
            if (date > min) {
                start = i;
            } else {
                if (i - start == k) {
                    count++;
                    start = i;
                }
            }
        }
        return count >= m;
    }
}
