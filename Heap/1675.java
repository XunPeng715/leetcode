class Solution {
    public int minimumDeviation(int[] nums) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i] % 2 == 0 ? nums[i] : nums[i] * 2;
            min = Math.min(min, num);
            pq.offer(num);
        }
        int res = Integer.MAX_VALUE;
        while (true) {
            int curr = pq.poll();
            res = Math.min(res, curr - min);
            if (curr % 2 == 1) {
                break;
            }
            min = Math.min(curr / 2, min);
            pq.offer(curr / 2);
        }
        return res;
    }
}
