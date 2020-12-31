class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deq = new LinkedList<>();
        for (int i = 0; i <= nums.length; i++) {
            if (i >= k) res[i - k] = deq.removeLast();
            if (i == nums.length) break;
            update(deq, nums[i]);
        }
        return res;
    }
    
    public void update(Deque<Integer> deq, int n) {
        int size = deq.size();
        while (!deq.isEmpty() && deq.peek() < n) {
            deq.removeFirst();
        }
        while (deq.size() != size + 1) {
            deq.addFirst(n);
        }
    }
}
