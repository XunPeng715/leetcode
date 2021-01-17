class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[arr.length];
        q.offer(start);
        visited[start] = 1;
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (arr[curr] == 0) {
                return true;
            }
            int[] directions = new int[]{-1, 1};
            for (int d : directions) {
                int next = curr + d * arr[curr];
                if (next >= 0 && next < arr.length && visited[next] == 0) {
                    q.offer(next);
                    visited[next] = 1;
                }
            }
        }
        return false;
    }
}
