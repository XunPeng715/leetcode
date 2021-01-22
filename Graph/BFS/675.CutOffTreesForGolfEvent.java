class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size();
        int n = forest.get(0).size();
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, -1});
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) != 0) {
                    pq.offer(new int[]{i, j, forest.get(i).get(j)});
                }
            }
        }
        int steps = 0;
        int[] prev = new int[]{0, 0, -1};
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int step = minStep(forest, m, n, prev, curr);
            prev = curr;
            if (step == Integer.MAX_VALUE) return -1;
            steps += step;
        }
        return steps;
    }
    
    public int minStep(List<List<Integer>> forest, int m, int n, int[] source, int[] destination) {
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[m][];
        for (int i = 0; i < m; i++) visited[i] = new int[n];
        visited[source[0]][source[1]] = 1;
        queue.offer(new int[]{source[0], source[1]});
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == destination[0] && curr[1] == destination[1]) {
                    return steps;
                }
                for (int[] d: directions) {
                    int r = curr[0] + d[0], c = curr[1] + d[1];
                    if (r >= 0 && r < m && c >= 0 && c < n && visited[r][c] == 0 && forest.get(r).get(c) != 0) {
                        visited[r][c] = 1;
                        queue.offer(new int[]{r, c});
                    }
                }
            }
            steps++;
        }
        return Integer.MAX_VALUE;
    }
}
