class Solution {
    public int shortestPathLength(int[][] graph) {
        int path = Integer.MAX_VALUE;
        for (int k = 0; k < graph.length; k++) {
            int currPath = bfs(graph, k);
            path = Math.min(path, currPath);
        }
        return path;
    }
    
    public int bfs(int[][] graph, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[3] == b[3]) {
                return b[2] - a[2];
            }
            return a[3] - b[3];
        });
        // visited nodes(bit mask) + curr node
        Set<String> visited = new HashSet<>();        
        visited.add((1 << k) + " " + k);
        // [curr node, visited nodes(bit mask), count of visited Node, length of path]
        pq.offer(new int[]{k, 1 << k, 1, 0});
        int currPath = 0;
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                int[] curr = pq.poll();
                if (curr[2] == graph.length) {
                    return currPath;
                }
                for (int nbr : graph[curr[0]]) {
                    int state = curr[1], count = curr[2];
                    if ((state & 1 << nbr) == 0) {
                        state |= 1 << nbr;
                        count++;
                    }
                    String key = state + " " + nbr;
                    if (visited.contains(key)) {
                        continue;
                    }
                    visited.add(key);
                    pq.offer(new int[]{nbr, state, count, currPath});
                }
            }
            currPath++;
        }
        return 0;
    }
}
