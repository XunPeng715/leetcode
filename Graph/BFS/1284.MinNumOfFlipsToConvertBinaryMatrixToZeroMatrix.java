class Solution {
    public int minFlips(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] flatMat = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                flatMat[i * n + j] = mat[i][j];
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(Arrays.toString(flatMat));
        queue.offer(flatMat);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (isAllZero(curr)) {
                    return level;
                }
                List<int[]> nextStops = generateStops(curr, m, n);
                for (int[] next : nextStops) {
                    String s = Arrays.toString(next);
                    if (!visited.contains(s)) {
                        visited.add(s);
                        queue.offer(next);
                    }
                }
            }
            level++;
        }
        return -1;
    }
    public List<int[]> generateStops(int[] p, int m, int n) {
        List<int[]> list = new ArrayList<>();
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] copy = Arrays.copyOf(p, m *n);
                copy[i * n + j] = 1 - copy[i * n + j];
                for (int[] d : directions) {
                    int r = i + d[0], c = j + d[1];
                    if (r >= 0 && r < m && c >= 0 && c < n) {
                        copy[r * n + c] = 1 - copy[r * n + c];
                    }
                }
                list.add(copy);
            }
        }
        return list;
    }
    
    public boolean isAllZero(int[] p) {
        for (int i = 0; i < p.length; i++) {
            if (p[i] == 1) return false;
        }
        return true;
    }
}
