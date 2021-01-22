class Solution {
    class Position {
        int r, c, dis;
        boolean isHole;
        String path;
        public Position(int r, int c, int dis, boolean isHole, String path) {
            this.r = r;
            this.c = c;
            this.dis = dis;
            this.isHole = isHole;
            this.path = path;
        }
    }
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {        
        // row, col, dis, isHole, path
        Queue<Position> pq = new PriorityQueue<Position>((a, b) -> {
            if (a.dis == b.dis) {
                return a.path.compareTo(b.path);
            }
            return a.dis - b.dis;
        });
        pq.offer(new Position(ball[0], ball[1], 0, false, ""));
        int[][] visited = new int[maze.length][];
        for (int i = 0; i < maze.length; i++) visited[i] = new int[maze[0].length];
        while (!pq.isEmpty()) {
            Position curr = pq.poll();
            if (curr.isHole) {
                return curr.path;
            }
            visited[curr.r][curr.c] = 1;
            for (Position next : nextPosition(maze, curr, hole)) {
                if (visited[next.r][next.c] == 0) {
                    pq.offer(next);
                }
            }
        }
        return "impossible";
    }
    
    public List<Position> nextPosition(int[][] maze, Position curr, int[] hole) {
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        String[] directionStrs = new String[]{"u", "d", "r", "l"};
        List<Position> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int[] d = directions[i];
            int r = curr.r, c = curr.c, dis = curr.dis;
            String p = curr.path + directionStrs[i];
            boolean isHole = false;
            while (r + d[0] >= 0 && r + d[0] < maze.length &&
                   c + d[1] >= 0 && c + d[1] < maze[0].length &&
                  maze[r + d[0]][c + d[1]] == 0) {
                r += d[0];
                c += d[1];
                dis++;
                if (r == hole[0] && c == hole[1]) {
                    isHole = true;
                    break;
                }
            }
            list.add(new Position(r, c, dis, isHole, p));
        }
        return list;
    }
}
