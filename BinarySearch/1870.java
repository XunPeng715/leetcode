class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int start = 1, end = 10000000;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (validSpeed(dist, hour, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (start > 10000000) {
            return -1;
        }
        return start;
    }
    
    public boolean validSpeed(int[] dist, double hour, int speed) {
        double res = (double) 0;
        for (int i = 0; i < dist.length - 1; i++) {
            int ride = dist[i];
            if (ride % speed != 0) {
                res += ride / speed + 1;
            } else {
                res += ride / speed;
            }
        }
        res += (double) dist[dist.length - 1] / speed;
        return res <= hour;
    }
}
