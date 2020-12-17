class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> sub, int[] nums, int index) {
        if (sub.size() >= 2) {
            res.add(new ArrayList<>(sub));
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (sub.size() != 0 && nums[i] < sub.get(sub.size() -1) || visited.contains(nums[i])) {
                continue;
            }
            visited.add(nums[i]);
            sub.add(nums[i]);
            dfs(res, sub, nums, i + 1);
            sub.remove(sub.size() - 1);   
        }
    }
}
