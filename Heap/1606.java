class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] count = new int[k];
        int max = 0;
        TreeSet<Integer> idleServers = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            idleServers.add(i);
        }
        // id, freeTime
        Queue<int[]> busyServers = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < arrival.length; i++) {
            while (!busyServers.isEmpty() && busyServers.peek()[1] <= arrival[i]) {
                int[] s = busyServers.poll();
                idleServers.add(s[0]);
            }
            Integer s = idleServers.ceiling(i % k);
            if (s == null) {
                s = idleServers.ceiling(i % k - k);
            }
            if (s == null) {
                continue;
            }
            
            idleServers.remove(s);
            busyServers.add(new int[]{s, arrival[i] + load[i]});
            count[s]++;
            max = Math.max(max, count[s]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                res.add(i);
            }
        }
        return res;
    }
}
