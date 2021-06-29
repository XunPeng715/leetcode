class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < slots1.length && j < slots2.length) {
            int s = Math.max(slots1[i][0], slots2[j][0]);
            int e = Math.min(slots1[i][1], slots2[j][1]);
            if (e - s >= duration) {
                res.add(s);
                res.add(s + duration);
                return res;
            }
            if (slots1[i][1] < slots2[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
}