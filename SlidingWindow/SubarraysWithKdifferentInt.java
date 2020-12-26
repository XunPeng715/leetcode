class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMost(A, K) - atMost(A, K - 1);
    }
    
    public int atMost(int[] A, int K) {
        int j = 0, res = 0;
        int[] counts = new int[A.length + 1];
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            counts[A[i]]++;
            if (counts[A[i]] == 1) count++;
            while (count > K) {
                counts[A[j]]--;
                if (counts[A[j]] == 0) count--;
                j++;
            }
            res += i - j;
        }
        return res;
    }
}
