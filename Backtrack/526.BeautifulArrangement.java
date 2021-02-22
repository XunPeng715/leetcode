class Solution {
    public int countArrangement(int N) {
        return dfs(N, 1, new HashSet<>());
    }
    
    public int dfs(int N, int index, Set<Integer> visited) {
        if (index == N + 1) {
            return 1;
        }
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (visited.contains(i) || (index % i != 0 && i % index != 0)) {
                continue;
            }
            visited.add(i);
            res += dfs(N, index + 1, visited);
            visited.remove(i);
        }
        return res;
    }
}
