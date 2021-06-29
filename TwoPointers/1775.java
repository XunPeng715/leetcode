class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = 0, sum2 = 0;
        for (int num : nums1) {
            sum1 += num;
        }
        for (int num : nums2) {
            sum2 += num;
        }
        if (sum1 == sum2) {
            return 0;
        } else if (sum1 < sum2) {
            return helper(nums1, nums2, sum2 - sum1);
        } else {
            return helper(nums2, nums1, sum1 - sum2);
        }
    }
    
    public int helper(int[] nums1, int[] nums2, int diff) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums1) {
            queue.offer(6 - num);
        }
        for (int num : nums2) {
            queue.offer(num - 1);
        }
        int count = 0;
        while (!queue.isEmpty() && diff > 0) {
            diff -= queue.poll();
            count++;
        }
        if (diff > 0) {
            return -1;
        }
        return count;
    } 
}
