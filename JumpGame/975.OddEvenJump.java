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
class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        int[][] memo = new int[2][arr.length];
        memo[0][n - 1] = 1;
        memo[1][n - 1] = 1;
        int count = 1;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(arr[n - 1], n - 1);
        for (int i = arr.length - 2; i >= 0; i--) {
            Integer ceil = treeMap.ceilingKey(arr[i]);
            if (ceil != null && memo[1][treeMap.get(ceil)] == 1) {
                memo[0][i] = 1;
            }
            Integer floor = treeMap.floorKey(arr[i]);
            if (floor != null && memo[0][treeMap.get(floor)] == 1) {
                memo[1][i] = 1;
            }
            treeMap.put(arr[i], i);
            count += memo[0][i];
        }
        return count;
    }
}}
