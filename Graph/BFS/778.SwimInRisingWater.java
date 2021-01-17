class Solution {
    // DFS
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int swimInWater(int[][] grid) {
        int N = grid.length * grid[0].length;
        int start = 0, end = N - 1;
        int mid = start;
        while (start <= end) {
            mid = start + (end - start) / 2;
            int[][] visited = new int[grid.length][];
            for (int i = 0; i < grid.length; i++) {
                visited[i] = new int[grid[0].length];
                Arrays.fill(visited[i], -1);
            }
            if (grid[0][0] <= mid && dfs(grid, mid, 0, 0, visited)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    
    public boolean dfs(int[][] grid, int max, int i, int j, int[][] visited) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return true;
        }
        visited[i][j] = 0;
        for (int[] d : directions) {
            int r = i + d[0];
            int c = j + d[1];
            if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] > max || visited[r][c] == 0) {
                continue;
            }            
            if (dfs(grid, max, r, c, visited)) {
                return true;
            }
        }
        return false;
    }
    // BFS
    public int swimInWater1(int[][] grid) {
        int H = grid.length, W = grid[0].length;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[] seen = new int[H * W];
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> grid[a / H][a % H] - grid[b / H][b % H]); 
        
        pq.offer(0);
        seen[0] = 1;        
        int res = 0;
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            int i = curr / H;
            int j = curr % H;
            res = Math.max(res, grid[i][j]);
            if (i == H - 1 && j == W - 1) break;
            for (int[] d : directions) {
                int r = i + d[0];
                int c = j + d[1];
                if (r < 0 || r >= H || c < 0 || c >= W || seen[r * H + c] == 1) {
                    continue;
                }
                seen[r * H + c] = 1;
                pq.offer(r * H + c);
            }
        }
        return res;
    }
    
}
