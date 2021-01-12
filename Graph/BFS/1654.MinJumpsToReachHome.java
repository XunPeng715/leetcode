class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> forbid = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for (int p : forbidden) forbid.add(p);
        Queue<int[]> pq = new PriorityQueue<>((m, n) -> m[2] - n[2]);
        pq.offer(new int[]{0, -1, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[0] == x) {
                return curr[2];
            }
            if (forbid.contains(curr[0])) {
                continue;
            }            
            if (curr[0] + a < 2000 + 2 * b && !visited.contains(Integer.toString(curr[0]) + ',' + Integer.toString(1))) {
                visited.add(Integer.toString(curr[0]) + ',' + Integer.toString(1));
                pq.add(new int[]{curr[0] + a, 1, curr[2] + 1});
            }            
            if (curr[1] == 1 && curr[0] - b > 0 && !visited.contains(Integer.toString(curr[0]) + ',' + Integer.toString(-1))) {
                visited.add(Integer.toString(curr[0]) + ',' + Integer.toString(-1));
                pq.add(new int[]{curr[0] - b, -1, curr[2] + 1});
            }
        }
        return -1;
    }
}
