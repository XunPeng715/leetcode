class Solution {
    public int maximizeSweetness(int[] sweetness, int K) {
        int start = 1, end = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (check(sweetness, K, mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
    
    public boolean check(int[] sweetness, int K, int min) {
        int count = 0;
        int curr = 0;
        for (int i = 0; i < sweetness.length; i++) {
            int sweet = sweetness[i];
            if (curr >= min) {
                count++;
                curr = sweet;
            } else {
                curr += sweet;
            }
        }
        if (curr >= min) count++;
        return count >= K + 1;
    }
}
