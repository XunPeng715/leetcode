class Solution {
    public int validSubarrays(int[] nums) {
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.getFirst() > num) {
                stack.removeFirst();
            }
            stack.addFirst(num);
            res += stack.size();
        }
        return res;
    }
}
