class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.size() + nums.length - i > k && stack.getFirst() > nums[i]) {
                stack.removeFirst();
            }
            stack.addFirst(nums[i]);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = stack.removeLast();
        }
        return res;
    }
}
