class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int count = 0;
        count += helper(nums1, nums2);
        count += helper(nums2, nums1);
        return count;
    }
    
    public int helper(int[] nums1, int[] nums2) {
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            long left = (long) nums1[i] * nums1[i];            
            int j = 0, k = nums2.length - 1;
            while (j < k) {
                if ((long) nums2[j] * nums2[k] > left) {
                    k--;
                } else if ((long) nums2[j] * nums2[k] < left) {
                    j++;
                } else {
                    if (nums2[j] == nums2[k]) {
                        count += (k - j) * (k - j + 1) / 2;
                        k = j;
                    } else {
                        int m = j, n = k;
                        while (nums2[j] == nums2[m]) {
                            j++;
                        }
                        while (nums2[k] == nums2[n]) {
                            k--;
                        }
                        count += (j - m) * (n - k);
                    }
                }
            }
        }
        return count;
    }
}
