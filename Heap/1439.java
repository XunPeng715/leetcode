class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(0);
        for (int i = 0; i < m; i++) {
            Queue<Integer> localPq = new PriorityQueue<>((a, b) -> b - a);
            while (!pq.isEmpty()) {
                int curr = pq.poll();
                for (int j = 0; j < n; j++) {
                    localPq.offer(curr + mat[i][j]);
                    if (localPq.size() > k) {
                        localPq.poll();
                    }
                }
            }
            pq = localPq;
        }
        return pq.poll();
    }
}
