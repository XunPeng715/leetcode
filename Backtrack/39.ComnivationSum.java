class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subnet = new ArrayList<>();
        dfs(res, subnet, candidates, 0, target);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> subnet, int[] candidates, int index, int target) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(subnet));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            subnet.add(candidates[i]);
            dfs(res, subnet, candidates, i, target - candidates[i]);
            subnet.remove(subnet.size() - 1);
        }
   }
}
