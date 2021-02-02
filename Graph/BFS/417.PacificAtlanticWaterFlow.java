class Solution {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] reachPacific = new int[m][n];        
        int[][] reachAtlantic = new int[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, reachPacific, i, 0);
            dfs(matrix, reachAtlantic, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(matrix, reachPacific, 0, j);
            dfs(matrix, reachAtlantic, m - 1, j);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (reachPacific[i][j] == 1 && reachAtlantic[i][j] == 1) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    
    public void dfs(int[][] matrix, int[][] reach, int i, int j) {
        if (reach[i][j] == 1) {
            return;
        }
        reach[i][j] = 1;        
        for (int[] d : directions) {
            int r = i + d[0], c = j + d[1];
            if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length && 
                reach[r][c] == 0 && matrix[r][c] >= matrix[i][j]) {
                dfs(matrix, reach, r, c);
            }
        }
    }
    
    public void bfs(int[][] matrix, int[][] reach, int i, int j) {
        int m = matrix.length, n = matrix[0].length;
        int[][] visited = new int[m][n];
        visited[i][j] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            reach[curr[0]][curr[1]] = 1;
            for (int[] d : directions) {
                int r = curr[0] + d[0], c = curr[1] + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n || 
                    visited[r][c] == 1 || matrix[curr[0]][curr[1]] > matrix[r][c]) {
                    continue;
                }
                visited[r][c] = 1;
                queue.offer(new int[]{r, c});
            }
        }
    }
}
