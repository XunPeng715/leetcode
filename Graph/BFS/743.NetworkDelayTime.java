class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1], time[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{K, 0});
        
        int res = 0;
        Set<Integer> visited = new HashSet<>();
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (visited.contains(curr[0])) continue;
            visited.add(curr[0]);
            res = curr[1];
            if (!graph.containsKey(curr[0])) continue;
            for (int nbr : graph.get(curr[0]).keySet()) {
                int weight = graph.get(curr[0]).get(nbr);
                pq.offer(new int[]{nbr, weight + curr[1]});
            }
        }
        return visited.size() == N ? res : -1;
    }
}
