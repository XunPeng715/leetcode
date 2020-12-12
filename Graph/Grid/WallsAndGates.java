// 286. Walls and Gates
class Solution {
    int[][] directions = new int[][]{{0, -1},{-1, 0}, {1, 0}, {0, 1}};
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    // bfs(rooms, i, j);
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }
    
    public void bfs(int[][] rooms, int r, int c) {
        Deque<int[]> queue = new LinkedList<>();
        queue.addFirst(new int[]{r, c});
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] room = queue.removeLast();
                for (int[] d : directions) {
                    int newRow = room[0] + d[0];
                    int newCol = room[1] + d[1];
                    if (newRow >= rooms.length || newRow < 0 || 
                        newCol >= rooms[0].length || newCol < 0) {
                        continue;
                    }
                    if (rooms[newRow][newCol] > level) {
                        rooms[newRow][newCol] = level;
                        queue.addFirst(new int[]{newRow, newCol});
                    }
                }
            }
            level++;
        }
    }
    
    public void dfs(int[][] rooms, int r, int c, int d) {
        for (int[] dir : directions) {
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            if (newRow >= 0 && newRow < rooms.length && 
                newCol >= 0 && newCol < rooms[0].length && 
                rooms[newRow][newCol] > d + 1) {
                rooms[newRow][newCol] = d + 1;
                dfs(rooms, newRow, newCol, d + 1);
            }
        }
    }
}
