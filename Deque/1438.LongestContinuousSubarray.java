class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int j = 0, res = 1;
        Deque<Integer> maxDeq = new LinkedList<>();
        Deque<Integer> minDeq = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!maxDeq.isEmpty() && nums[maxDeq.getLast()] < nums[i]) {
                maxDeq.removeLast();
            }
            while (!minDeq.isEmpty() && nums[minDeq.getLast()] > nums[i]) {
                minDeq.removeLast();
            }
            maxDeq.addLast(i);
            minDeq.addLast(i);
            while (nums[maxDeq.getFirst()] - nums[minDeq.getFirst()] > limit) {
                if (minDeq.getFirst() <= j) {
                    minDeq.removeFirst();
                }
                if (maxDeq.getFirst() <= j) {
                    maxDeq.removeFirst();
                }
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
