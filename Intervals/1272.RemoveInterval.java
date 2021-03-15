class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> list = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[1] <= toBeRemoved[0] || interval[0] >= toBeRemoved[1]) {
                list.add(Arrays.asList(interval[0], interval[1]));
            } else {
                int start1 = interval[0];
                int end1 = toBeRemoved[0];
                if (start1 < end1) list.add(Arrays.asList(start1, end1));
                int start2 = toBeRemoved[1];
                int end2 = interval[1];
                if (start2 < end2) list.add(Arrays.asList(start2, end2));
            }
        }
        return list;
    }
}
