class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            int curr = nums[i];
            while (!stack.isEmpty() && curr > stack.peek()) {
                stack.removeFirst();
            }
            stack.addFirst(curr);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int curr = nums[i];
            while (!stack.isEmpty() && curr >= stack.peek()) {
                stack.removeFirst();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.addFirst(curr);
        }
        return res;
    }
}
