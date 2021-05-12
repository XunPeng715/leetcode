class Solution {
    public int hIndex(int[] citations) {
        int mid = 0;
        int start = 0, end = citations.length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (citations[citations.length - mid - 1] == mid + 1) {
                return mid + 1;
            } else if (citations[citations.length - mid - 1] > mid + 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
} 
