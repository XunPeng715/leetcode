class Solution {
    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int K) {
        List<Map<Integer, Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new HashMap<>());
        for (int[] f : flights) {
            graph.get(f[0]).put(f[1], f[2]);
        }
        // pq: [city, stops, cost]
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{src, -1, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();            
            if (curr[1] > K) continue;
            int city = curr[0];
            if (city == dst) return curr[2];
            for (int nextCity : graph.get(city).keySet()) {
                int nextCost = graph.get(city).get(nextCity);
                pq.add(new int[]{nextCity, curr[1] + 1, curr[2] + nextCost});
            }
        }
        return -1;
    }
}
