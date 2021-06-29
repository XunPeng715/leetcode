class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        return helper(nums1, nums2) + helper(nums2, nums1);
    }
    
    public int helper(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (int j = 0; j < nums2.length; j++) {
            for (int k = j + 1; k < nums2.length; k++) {
                long p = (long) nums2[j] * nums2[k];
                double s = Math.sqrt(p);
                if (Math.pow((long) s, 2) != p) {
                    continue;
                }
                int sInt = (int) s;
                if (!map.containsKey(sInt)) {
                    continue;
                }
                count += map.get(sInt);
            }
        }
        return count;
    }
}
