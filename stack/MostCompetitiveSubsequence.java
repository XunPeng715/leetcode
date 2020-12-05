class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> deq = new LinkedList<>();
        int[] res = new int[k];
        for (int i = 0; i < nums.length; i++) {            
            while (!deq.isEmpty() && deq.peek() > nums[i]) deq.removeFirst();
            deq.addFirst(nums[i]);
            if (i >= nums.length - k) res[i - nums.length + k] = deq.removeLast();
        }
        return res;
    }
}
