class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] arr = new int[intervals.length * 2][2];
        for (int i = 0; i < intervals.length; i++) {
            arr[i * 2] = new int[]{intervals[i][0], 1};
            arr[i * 2 + 1] = new int[]{intervals[i][1], -1};
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        List<int[]> list = new ArrayList<>();
        int count = 0;
        int start = 0, end = 0;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i][1];
            if (count == 1 && arr[i][1] == 1) {
                start = arr[i][0];
            } else if (count == 0 && arr[i][1] == -1) {
                end = arr[i][0];
                list.add(new int[]{start, end});
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }
}
