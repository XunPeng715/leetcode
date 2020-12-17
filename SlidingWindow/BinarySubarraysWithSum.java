class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int[] counts = new int[A.length + 1];
        int prevSum = 0;
        counts[0] = 1;
        int res = 0;
        for (int i : A) {
            prevSum += i;            
            if (prevSum - S >= 0) {
                res += counts[prevSum - S]; 
            }
            counts[prevSum]++;
        }
        return res;
    }
    
    public int numSubarraysWithSum1(int[] A, int S) {
        return atMost(A, S) - atMost(A, S - 1);
    }
    
    public int atMost(int[] A, int S) {
        int j = 0;
        int count = 0;
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) count++;
            while (j <= i && count > S) {
                if (A[j] == 1) count--;
                j++;
            }
            res += i - j + 1;
        }
        return res;
    }
}
