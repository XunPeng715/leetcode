class Solution {
    public int findLatestStep(int[] arr, int m) {
        int[] day = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            day[arr[i] - 1] = i + 1;
        }
        int res = -1;
        // first |-------------| last
        Deque<Integer> deq = new LinkedList<>();
        for (int i = 0; i < day.length; i++) {
            while (!deq.isEmpty() && day[i] > day[deq.getLast()]) {
                deq.removeLast();
            }
            while (!deq.isEmpty() && i - deq.getFirst() >= m) {
                deq.removeFirst();
            }
            deq.addLast(i);
            if (i < m - 1) continue;
            int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
            if (i >= m) {
                left = day[i - m];
            }
            if (i < day.length - 1) {
                right = day[i + 1];
            }
            if (left == Integer.MAX_VALUE && right == Integer.MAX_VALUE) {
                res = day[deq.getFirst()];
            } else if (day[deq.getFirst()] < left && day[deq.getFirst()] < right) {
                res = Math.max(res, Math.min(left, right) - 1);
            }    
        }
        return res;
    } 
}
