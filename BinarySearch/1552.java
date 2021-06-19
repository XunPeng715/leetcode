class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int length = position.length;
        int start = 0, end = position[length - 1];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (valid(mid, m, position)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
    
    public boolean valid(int force, int m, int[] position) {
        int count = 1;
        int prev = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - prev >= force) {
                count++;
                prev = position[i];
            }
            if (count >= m) return true;
        }
        return false;
    }
}
