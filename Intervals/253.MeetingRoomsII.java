class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[][] arr = new int[intervals.length * 2][2];
        for (int i = 0; i < intervals.length; i++) {
            arr[i * 2] = new int[]{intervals[i][0], 1};
            arr[i * 2 + 1] = new int[]{intervals[i][1], -1};
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        int room = 0;
        int currRoom = 0;
        for (int i = 0; i < arr.length; i++) {
            currRoom += arr[i][1];
            room = Math.max(room, currRoom);
        }
        return room;
    }
}
