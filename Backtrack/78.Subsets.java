class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subnet = new ArrayList<>();
        dfs(nums, res, subnet, 0);
        return res;
    }
    
    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> subnet, int index) {
        res.add(new ArrayList<>(subnet));
        for (int i = index; i < nums.length; i++) {
            subnet.add(nums[i]);
            dfs(nums, res, subnet, i + 1);
            subnet.remove(subnet.size() - 1);
        }
    }
}
