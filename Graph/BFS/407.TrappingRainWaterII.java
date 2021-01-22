class Solution {
    public int trapRainWater(int[][] heightMap) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int[][] visited = new int[heightMap.length][];
        for (int i = 0; i < heightMap.length; i++) visited[i] = new int[heightMap[0].length];
        for (int i = 0; i < heightMap.length; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, heightMap[0].length - 1, heightMap[i][heightMap[0].length - 1]});
            visited[i][0] = 1;
            visited[i][heightMap[0].length - 1] = 1;
        }        
        for (int i = 1; i < heightMap[0].length - 1; i++) {
            pq.offer(new int[]{0, i, heightMap[0][i]});
            pq.offer(new int[]{heightMap.length - 1, i, heightMap[heightMap.length - 1][i]});
            visited[0][i] = 1;
            visited[heightMap.length - 1][i] = 1;
        }
        int res = 0;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            curr = curr;
            for (int[] d : directions) {
                int r = curr[0] + d[0];
                int c = curr[1] + d[1];
                if (r > 0 && r < heightMap.length && c > 0 && c < heightMap[0].length && visited[r][c] == 0) {
                    visited[r][c] = 1;                    
                    res += Math.max(0, curr[2] - heightMap[r][c]);
                    pq.offer(new int[]{r, c, Math.max(curr[2], heightMap[r][c])});
                }
            }
        }
        return res;
    }
}
