class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {        
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);        
        int[][] visited = new int[maze.length][];
        for (int i = 0; i < maze.length; i++) visited[i] = new int[maze[0].length];        
        pq.offer(new int[]{start[0], start[1], 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return curr[2];
            }
            visited[curr[0]][curr[1]] = 1;
            for (int[] next : nextPosition(maze, curr)) {
                if (visited[next[0]][next[1]] == 0) {
                    pq.offer(next);
                }
            }
        }
        return -1;
    }

    public List<int[]> nextPosition(int[][] maze, int[] curr) {
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        List<int[]> list = new ArrayList<>();
        for (int[] d: directions) {
            int[] p = Arrays.copyOf(curr, curr.length);
            while (d[0] + p[0] >= 0 && d[0] + p[0] < maze.length && 
                   d[1] + p[1] >= 0 && d[1] + p[1] < maze[0].length && 
                   maze[d[0] + p[0]][d[1] + p[1]] == 0) {
                p[0] += d[0];
                p[1] += d[1];
                p[2] += 1;
            }
            list.add(p);
        }
        return list;
    }
}
