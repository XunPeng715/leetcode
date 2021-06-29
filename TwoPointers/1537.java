class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        long res = 0L, sum1 = 0L, sum2 = 0L;
        int i = 0, j = 0;        
        while (i < nums1.length || j < nums2.length) {
            if (i == nums1.length) {                
                sum2 += (long) nums2[j];
                j++;
            } else if (j == nums2.length) {                
                sum1 += (long) nums1[i];
                i++;
            } else if (nums1[i] == nums2[j]) {
                res += (long) Math.max(sum1, sum2);
                sum1 = (long) nums1[i];
                sum2 = (long) nums2[j];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {                
                sum1 += (long) nums1[i];
                i++;
            } else {                
                sum2 += (long) nums2[j];
                j++;
            }
        }
        res += (long) Math.max(sum1, sum2);
        return (int) (res % 1000000007);
    }
}
