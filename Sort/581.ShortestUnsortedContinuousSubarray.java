class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int left = nums.length - 1, right = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.getFirst()]) {
                left = Math.min(left, stack.removeFirst());
            }
            stack.addFirst(i);
        }
        stack = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.getFirst()]) {
                right = Math.max(right, stack.removeFirst());
            }
            stack.addFirst(i);
        }
        int res = right - left > 0 ? right - left + 1 : 0;
        return res;
    }
}
