class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendsSet = new HashSet<>();
        for (String deadend : deadends) deadendsSet.add(deadend);
        if (deadendsSet.contains("0000")) {
            return -1;
        }
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int change = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(target)) {
                    return change;
                }
                List<String> nextStrs = generateNextStrs(curr);
                for (String str : nextStrs) {
                    if (deadendsSet.contains(str) || visited.contains(str)) {
                        continue;
                    }
                    visited.add(str);
                    queue.offer(str);
                }
            }
            change++;
        }
        return -1;
    }
    
    public List<String> generateNextStrs(String s) {
        List<String> list = new ArrayList<>();        
        for (int i = 0; i < s.length(); i++) {
            char[] arr = s.toCharArray();
            char c = arr[i];
            int up = ((c - '0') + 11) % 10;
            arr[i] = (char) (up + '0');
            list.add(new String(arr));
            int down = ((c - '0') + 9) % 10;
            arr[i] = (char) (down + '0');
            list.add(new String(arr));
        }
        return list;
    }
}
