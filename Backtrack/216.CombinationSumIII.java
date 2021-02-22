class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subnet = new ArrayList<>();
        dfs(res, subnet, 1, k, n);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> subnet, int start, int k, int n) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(subnet));
        }
        if (k == 0 || n < 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            subnet.add(i);
            dfs(res, subnet, i + 1, k - 1, n - i);
            subnet.remove(subnet.size() - 1);
        }
    }
}
