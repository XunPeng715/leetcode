class Solution {
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        Deque<Integer> deq = new LinkedList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            while (!deq.isEmpty() && dp[deq.getLast()] <= dp[i]) {
                deq.removeLast();
            }
            while (!deq.isEmpty() && i - deq.getFirst() >= k) {
                deq.removeFirst();
            }
            deq.addLast(i);
            dp[i + 1] = nums[i + 1] + dp[deq.getFirst()];
        }        
        return dp[nums.length - 1];
    }
}
