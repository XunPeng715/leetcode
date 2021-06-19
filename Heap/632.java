class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> nums.get(b[0]).get(b[1]) - nums.get(a[0]).get(a[1]));
        int currMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = nums.get(i);
            currMin = Math.min(currMin, list.get(list.size() - 1));
            pq.offer(new int[]{i, list.size() - 1});
        }
        int min = Integer.MAX_VALUE, max = 0, minDiff = Integer.MAX_VALUE;
        while(true) {
            int[] curr = pq.poll();
            if (nums.get(curr[0]).get(curr[1]) - currMin <= minDiff) {
                min = currMin;
                max = nums.get(curr[0]).get(curr[1]);
                minDiff = max - min;
            }
            if (curr[1] == 0) {
                break;
            }
            currMin = Math.min(currMin, nums.get(curr[0]).get(curr[1] - 1));
            pq.offer(new int[]{curr[0], curr[1] - 1});
        }
        return new int[]{min, max};
    }
}
