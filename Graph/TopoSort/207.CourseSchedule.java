class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) graph.add(new HashSet());
        for (int[] req : prerequisites) {
            indegree[req[0]]++;
            graph.get(req[1]).add(req[0]);
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.addLast(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.removeFirst();
            for (int nbr : graph.get(curr)) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    queue.addLast(nbr);
                }
            }
            count++;
        }
        return numCourses == count;
    }
}
