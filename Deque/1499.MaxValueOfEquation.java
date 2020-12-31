class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int[][] tmp = new int[points.length][];
        for (int i = 0; i < points.length; i++) {
            tmp[i] = new int[2];
            tmp[i][0] = points[i][0];
            tmp[i][1] = points[i][1] - points[i][0];
        }
        int res = Integer.MIN_VALUE;
        Deque<Integer> deq = new LinkedList<>();
        for (int i = 0; i < points.length; i++) {            
            while (!deq.isEmpty() && tmp[i][0] - tmp[deq.getFirst()][0] > k) {
                deq.removeFirst();
            }
            if (!deq.isEmpty()) {
                res = Math.max(res, points[i][1] + points[i][0] + tmp[deq.getFirst()][1]);
            }
            while (!deq.isEmpty() && tmp[i][1] > tmp[deq.getLast()][1]) {
                deq.removeLast();
            }
            deq.addLast(i);
        }
        return res;
    }
}
