class Solution {
    public int shortestPathAllKeys(String[] grid) {        
        int x = 0, y = 0, max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    x = i;
                    y = j;
                } else if (c >= 'a' && c <= 'f') {
                    max = Math.max(max, c - 'a' + 1);
                }
            }
        }
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        visited.add(0 + " " + x + " " + y);
        queue.offer(new int[]{0, x, y});
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                x = curr[1];
                y = curr[2];
                if (curr[0] == (1 << max) - 1) {
                    return steps;
                }
                for (int[] d : directions) {
                    int r = x + d[0], c = y + d[1], keys = curr[0];                                      
                    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length()) {
                        continue;
                    }
                    char ch = grid[r].charAt(c);
                    if (ch == '#') {
                        continue;
                    } 
                    if (ch >= 'A' && ch <= 'F' && ((keys >> (ch - 'A')) & 1) == 0) {
                        continue;
                    }
                    if (ch >= 'a' && ch <= 'f') {
                        keys |= 1 << (ch - 'a');
                    }
                    String state = keys + " " + r + " " + c;
                    if (!visited.contains(state)) {
                        visited.add(state);
                        queue.offer(new int[]{keys, r, c});                        
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
