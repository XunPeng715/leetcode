class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] visited = new int[m][];
        for (int i = 0; i < m; i++) {
            visited[i] = new int[n];
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        visited[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int maxCost = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[0] == m - 1 && curr[1] == n - 1) {
                maxCost = Math.min(maxCost, curr[2]);
            }
            for (int i = 1; i <= 4; i++) {
                int[] d = directions[i - 1];
                int r = curr[0] + d[0], c = curr[1] + d[1];
                int cost = curr[2];
                if (r < 0 || r >= m || c < 0 || c >= n) {
                    continue;
                }
                if (grid[curr[0]][curr[1]] != i) {
                    cost++;
                }
                if (visited[r][c] > cost) {
                    visited[r][c] = cost;
                    pq.offer(new int[]{r, c, cost});
                }
            }
        }
        return maxCost;
    }
}
