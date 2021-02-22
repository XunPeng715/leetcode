class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subnet = new ArrayList<>();
        dfs(res, subnet, n, k, 1);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> subnet, int n, int k, int start) {
        if (subnet.size() == k) {
            res.add(new ArrayList<>(subnet));
            return;
        }
        for (int i = start; i <= n; i++) {
            subnet.add(i);
            dfs(res, subnet, n, k, i + 1);
            subnet.remove(subnet.size() - 1);
        }
    }
}
