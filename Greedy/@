class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> {
            if (a[1] < 0 && b[1] >= 0) {
                return -1;
            } else if (a[1] > 0 && b[1] <= 0) {
                return 1;
            }
            return a[1] - b[1];
        });
        int count = 1;
        int position = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > position) {
                count++;
                position = points[i][1];
            }
        }
        return count;
    }
}
