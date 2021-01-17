class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] visited = new int[maze.length][];
        for (int i = 0; i < maze.length; i++) visited[i] = new int[maze[0].length];
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        visited[start[0]][start[1]] = 1;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }
            for (int[] d: directions) {
                int[] next = nextPosition(maze, curr, d);
                if (visited[next[0]][next[1]] == 1) {
                    continue;
                }
                visited[next[0]][next[1]] = 1;
                queue.offer(next);
            }
        }
        return false;
    }
    
    public int[] nextPosition(int[][] maze, int[] p, int[] d) {
        int[] curr = Arrays.copyOf(p, p.length);
        while (curr[0] + d[0] >= 0 && curr[0] + d[0] < maze.length && 
               curr[1] + d[1] >= 0 && curr[1] + d[1] < maze[0].length && 
               maze[curr[0] + d[0]][curr[1] + d[1]] == 0) {
            curr[0] += d[0];
            curr[1] += d[1];
        }
        return curr;
    }
}
