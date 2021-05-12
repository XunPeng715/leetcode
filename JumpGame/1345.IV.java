class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            if (!map.containsKey(curr)) {
                map.put(curr, new ArrayList<>());
            }
            map.get(curr).add(i);
        }
        int[] visited = new int[arr.length];
        visited[0] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                if (index == arr.length - 1) {
                    return step;
                }
                List<Integer> nextPositions = map.get(arr[index]);
                nextPositions.add(index + 1);
                nextPositions.add(index - 1);
                for (int next : nextPositions) {
                    if (next >= 0 && next < arr.length && visited[next] == 0) {
                        queue.offer(next);
                        visited[next] = 1;
                    }
                }
                nextPositions.clear();
            }
            step++;
        }
        return step;
    }
}
