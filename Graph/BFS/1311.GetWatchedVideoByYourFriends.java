class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<String> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(id);
        queue.offer(id);
        int l = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (l == level) {
                break;
            }
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int f : friends[curr]) {
                    if (!visited.contains(f)) {
                        visited.add(f);
                        queue.offer(f);
                    }
                }
            }
            l++;
        }
        
        Map<String, Integer> count = new HashMap<>();
        while (!queue.isEmpty()) {
            int currId = queue.poll();
            for (String s : watchedVideos.get(currId)) {
                count.put(s, count.getOrDefault(s, 0) + 1);
                if (count.get(s) == 1) res.add(s);
            }
        }
        Collections.sort(res, (a, b) -> {
            if (count.get(a) == count.get(b)) {
                return a.compareTo(b);
            }
            return count.get(a) - count.get(b);
        });
        return res;
    }
}
