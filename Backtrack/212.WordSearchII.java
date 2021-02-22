class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (exist(board, word)) {
                res.add(word);
            }
        }
        return res;
    }
    
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    int[][] visited = new int[m][n];
                    visited[i][j] = 1;
                    if (dfs(board, word, i, j, 1, m, n, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean dfs(char[][] board, String word, int i, int j, int index, int m, int n, int[][] visited) {
        if (index == word.length()) {
            return true;
        }
        for (int[] d : directions) {
            int r = d[0] + i, c = d[1] + j;
            if (r >= 0 && r < m && c >= 0 && c < n && visited[r][c] == 0 && word.charAt(index) == board[r][c]) {
                visited[r][c] = 1;
                if (dfs(board, word, r, c, index + 1, m, n, visited)) {
                    return true;
                }
                visited[r][c] = 0;
            }
        }
        return false;
    }
}
