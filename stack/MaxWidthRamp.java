class Solution {
    public int maxWidthRamp(int[] A) {
        Integer[] B = new Integer[A.length];
        for (int i = 0; i < A.length; i++) B[i] = i;
        Arrays.sort(B, (i, j) -> {
            if (A[i] == A[j]) return i - j;
            return A[i] - A[j];
        });
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i : B) {
            res = Math.max(res, i - min);
            min = Math.min(min, i);            
        }
        return res;
    }
}
