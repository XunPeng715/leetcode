class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], x -> new ArrayList<>()).add(i);
        }
        int[] visited = new int[arr.length];
        visited[0] = 1;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[0] == arr.length - 1) {
                return curr[1];
            }
            List<Integer> nextPositions = map.get(arr[curr[0]]);
            nextPositions.add(curr[0] + 1);
            nextPositions.add(curr[0] - 1);
            for (int next : nextPositions) {
                if (next >= 0 && next < arr.length && visited[next] == 0) {
                    pq.offer(new int[]{next, curr[1] + 1});
                    visited[next] = 1;
                }
            }
            nextPositions.clear();
        }
        return -1;
    }
}
