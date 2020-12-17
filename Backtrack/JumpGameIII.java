class Solution {
    public boolean canReach(int[] arr, int start) {
        int[] visited = new int[arr.length];
        visited[start] = 1;
        return dfs(arr, visited, start);
    }
    
    public boolean dfs(int[] arr, int[] visited, int start) {
        if (arr[start] == 0) {
            return true;
        }
        int[] directions = new int[]{-1, 1};
        for (int d : directions) {
            int index = start + arr[start] * d;
            if (index < 0 || index >= arr.length || visited[index] == 1) continue;
            visited[index] = 1;
            if (dfs(arr, visited, index)) {
                return true;
            }
            visited[index] = 0;
        }
        return false;
    }
}
