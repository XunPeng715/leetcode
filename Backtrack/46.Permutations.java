class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        dfs(nums, res, new ArrayList<>(), visited);
        return res;
    }
    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> subnet, int[] visited) {
        if (subnet.size() == nums.length) {
            res.add(new ArrayList<>(subnet));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            subnet.add(nums[i]);
            dfs(nums, res, subnet, visited);
            visited[i] = 0;
            subnet.remove(subnet.size() - 1);            
        }
    }
}
