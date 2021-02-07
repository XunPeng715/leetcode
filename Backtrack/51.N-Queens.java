class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<char[]> solution = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] arr = new char[n];
            Arrays.fill(arr, '.');
            solution.add(arr);
        }
        dfs(res, solution, 0, n);
        return res;
    }
    
    public void dfs(List<List<String>> res, List<char[]> solution, int row, int n) {
        if (row == n) {
            List<String> subRes = new ArrayList<>();
            for (char[] arr : solution) {
                subRes.add(new String(arr));
            }
            res.add(subRes);
            return;
        }
        char[] arr = solution.get(row); 
        for (int i = 0; i < n; i++) {
            if (isValid(solution, row, i, n)) {
                arr[i] = 'Q';
                dfs(res, solution, row + 1, n);
                arr[i] = '.';
            }
        }
    }
    
    public boolean isValid(List<char[]> solution, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            int dif = row - i;
            if (col - dif >= 0 && solution.get(i)[col -dif] == 'Q') {
                return false;
            }
            if (col + dif < n && solution.get(i)[col + dif] == 'Q') {
                return false;
            }
            if (solution.get(i)[col] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
