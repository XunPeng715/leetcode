class Solution {
    public boolean canReach(int[] arr, int start) {
        int[] visited = new int[arr.length];
        return dfs(arr, start, visited);
    }
    
    public boolean dfs(int[] arr, int start, int[] visited) {
        if (arr[start] == 0) {
            return true;
        }
        if (start + arr[start] < arr.length && visited[start + arr[start]] == 0) {
            visited[start + arr[start]] = 1;
            if (dfs(arr, start + arr[start], visited)) return true;
        }
        if (start - arr[start] >= 0 && visited[start - arr[start]] == 0) {
            visited[start - arr[start]] = 1;
            if (dfs(arr, start - arr[start], visited)) return true;
        }
        return false;
    }
}
