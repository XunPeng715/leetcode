class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        int count = 0;
        int position = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < position) {
                count++;
                if (intervals[i][1] > position) {
                    continue;
                }                
            }
            position = intervals[i][1];
        }
        return count;
    }
}
