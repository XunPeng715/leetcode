class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (m, n) -> {
            return m[1] - m[0] - n[1] + n[0]; 
        });
        int res = 0;
        for (int i = 0; i < tasks.length; i++) {
            res = Math.max(res + tasks[i][0], tasks[i][1]);
        }
        return res;
    }
}
