class Solution {
    public int shortestSubarray(int[] A, int K) {
        Deque<Integer> deq = new LinkedList<>();
        int[] preSum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            preSum[i + 1] = A[i] + preSum[i];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < preSum.length; i++) {
            while (!deq.isEmpty() && preSum[i] < preSum[deq.getFirst()]) {
                deq.removeFirst();
            }
            while (!deq.isEmpty() && preSum[i] - preSum[deq.getLast()] >= K) {
                res = Math.min(res, i - deq.removeLast());
            }
            deq.addFirst(i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
