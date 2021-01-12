class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        Deque<Integer> deq = new LinkedList<>();
        deq.addLast(0);
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[deq.getFirst()], 0) + nums[i];
            while (!deq.isEmpty() && dp[i] > dp[deq.getLast()]) {
                deq.removeLast();
            }
            while (!deq.isEmpty() && i - deq.getFirst() >= k) {
                deq.removeFirst();
            }
            deq.addLast(i);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
