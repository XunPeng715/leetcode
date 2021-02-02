class Solution {
    public int snakesAndLadders(int[][] board) {
        int N = board.length;
        int[] visited = new int[N * N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = 1;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int S = queue.poll();
                if (S == N * N) {
                    return step;
                }
                for (int s = S + 1; s <= Math.min(S + 6, N * N); s++) {
                    int next = s;                    
                    int i = N - (next - 1) / N - 1;
                    int j = Math.min(2 * N - (next - 1) % (2 * N) - 1, (next - 1) % (2 * N));
                    if (board[i][j] != -1) {
                        next = board[i][j];
                    }
                    if (visited[next] == 1) {
                        continue;
                    }
                    visited[next] = 1;
                    queue.offer(next);
                }
            }
            step++;
        }
        return -1;
    }
}
