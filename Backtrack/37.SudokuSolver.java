class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board, 0);
    }
    
    public boolean dfs(char[][] board, int n) {
        while (n < 81 && board[n / 9][n % 9] != '.') {
            n++;
        }
        if (n == 81) {
            return true;
        }
        int x = n / 9, y = n % 9;
        List<Character> candidates = generate(board, x, y);
        for (char candidate : candidates) {
            board[x][y] = candidate;
            if (dfs(board, n + 1)) {
                return true;
            }
            board[x][y] = '.';
        }
        return false;
    }
    
    public List<Character> generate(char[][] board, int x, int y) {
        List<Character> candidates = new ArrayList<>();
        int m = x / 3, n = y / 3;
        Set<Character> exists = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                exists.add(board[m * 3 + i][n * 3 + j]);
            }
        }
        for (int i = 0; i < 9; i++) exists.add(board[i][y]);
        for (int j = 0; j < 9; j++) exists.add(board[x][j]);
        for (char c = '1'; c <= '9'; c++) {
            if (!exists.contains(c)) {
                candidates.add(c);
            }
        }
        return candidates;
    }
}
