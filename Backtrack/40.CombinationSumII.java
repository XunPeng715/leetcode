class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            subnet.add(candidates[i]);
            dfs(res, subnet, candidates, i + 1, target - candidates[i]);
            subnet.remove(subnet.size() - 1);
        }
    }
}
