class Solution {
    public int maxSumMinProduct(int[] nums) {
        int[] leftSmall = new int[nums.length];
        // monostack increasing to find small;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.getFirst()] >= nums[i]) {
                stack.removeFirst();
            }
            leftSmall[i] = stack.isEmpty() ? -1 : stack.getFirst();
            stack.addFirst(i);
        }
        int[] rightSmall = new int[nums.length];
        stack = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.getFirst()] >= nums[i]) {
                stack.removeFirst();
            }
            rightSmall[i] = stack.isEmpty() ? nums.length : stack.getFirst();
            stack.addFirst(i);
        }
        long[] sum = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        long res = 0L;
        for (int i = 0; i < nums.length; i++) {
            int left = leftSmall[i] + 1, right = rightSmall[i] - 1;
            res = Math.max(res, (long) nums[i] * (sum[right + 1] - sum[left]));
        }
        return (int) (res % 1000000007);
    }
}
