class Solution {
    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> res = new ArrayList<>();
        if (0 >= low && 0 <= high) res.add(0);
        for (int i = 1; i <= 9; i++) {
            dfs(res, i, low, high);
        }
        Collections.sort(res);
        return res;
    }
    
    public void dfs(List<Integer> res, long curr, int low, int high) {
        if (curr >= low && curr <= high) {
            res.add((int) curr);
        }
        if (curr >= high) return;
        if (curr % 10 > 0) {
            dfs(res, curr * 10 + curr % 10 - 1, low, high);
        }
        if (curr % 10 < 9) {
            dfs(res, curr * 10 + curr % 10 + 1, low, high);
        }
    }
}
