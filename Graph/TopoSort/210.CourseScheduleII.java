class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) graph.add(new HashSet<>());
        for (int[] req : prerequisites) {
            graph.get(req[1]).add(req[0]);
            indegree[req[0]]++;
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) if (indegree[i] == 0) queue.offer(i);
        
        int[] res = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res[count] = curr;
            count++;
            for (int nbr : graph.get(curr)) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    queue.offer(nbr);
                }
            }
        }
        return (count == numCourses) ? res : new int[0];
    }
}
