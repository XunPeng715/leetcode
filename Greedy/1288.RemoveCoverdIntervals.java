class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int[] prevInterval = new int[2];
        int count = 0;
        for (int[] interval : intervals) {
            if (interval[0] >= prevInterval[0] && interval[1] <= prevInterval[1]) {
                count++;
                continue;
            }
            prevInterval = interval;
        }
        return intervals.length - count;
    }
}
