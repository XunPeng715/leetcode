class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int curr = nums2[i];
            while (!stack.isEmpty() && stack.peek() < curr) {
                stack.removeFirst();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.addFirst(curr);
        }
        for (int i = 0; i < nums1.length; i++) res[i] = map.get(nums1[i]);
        return res;
    }
}
