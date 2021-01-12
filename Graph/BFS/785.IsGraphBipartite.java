class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<int[]> queue = new LinkedList<>();
        int[] visited = new int[graph.length];
        Arrays.fill(visited, -1);
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] != -1) {
                continue;
            }
            queue.offer(new int[]{i, 0});
            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                if (visited[curr[0]] != -1 && Math.abs(curr[1] - visited[curr[0]]) % 2 == 1) {
                    return false;
                }
                if (visited[curr[0]] != -1) {
                    continue;
                }
                visited[curr[0]] = curr[1];
                for (int nbr : graph[curr[0]]) {
                    queue.add(new int[]{nbr, curr[1] + 1});
                }
            }
        }
        return true;
    }
}
