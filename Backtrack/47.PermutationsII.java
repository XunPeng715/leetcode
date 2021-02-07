class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subnet = new ArrayList<>();
        int[] visited = new int[nums.length];
        dfs(nums, res, subnet, visited);
        return res;
    }
    
    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> subnet, int[] visited) {
        if (subnet.size() == nums.length) {
            res.add(new ArrayList<>(subnet));
            return;
        }
        int prevIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if ((prevIndex > -1 && nums[i] == nums[prevIndex]) || visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            subnet.add(nums[i]);
            dfs(nums, res, subnet, visited);
            visited[i] = 0;
            subnet.remove(subnet.size() - 1);
            prevIndex = i;
        }
    }
}
