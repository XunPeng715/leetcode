class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        int[][] grid = new int[n][n];
        dfs(grid, 0, n);
        return count;
    }
    
    public void dfs(int[][] grid, int row, int n) {
        if (row == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(grid, row, i, n)) {
                continue;
            }
            grid[row][i] = 1;
            dfs(grid, row + 1, n);
            grid[row][i] = 0;
        }
    }
    
    public boolean isValid(int[][] grid, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            int dif = row - i;
            if (grid[i][col] == 1) {
                return false;
            }
            if (col - dif >= 0 && grid[i][col - dif] == 1) {
                return false;
            }
            if (col + dif < n && grid[i][col + dif] == 1) {
                return false;
            }
        }
        return true;
    }
}
