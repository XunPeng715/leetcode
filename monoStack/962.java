class Solution {
    public int maxWidthRamp(int[] nums) {
        // monostack decreasing find the first small
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[stack.getFirst()] > nums[i]) {
                stack.addFirst(i);
            }
        }
        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.getFirst()]) {
                res = Math.max(res, i - stack.getFirst());
                stack.removeFirst();
            }
        }
        return res;
    }
}
