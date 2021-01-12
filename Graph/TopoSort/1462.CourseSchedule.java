class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        int[] indegree = new int[n];
        List<List<Integer>> graph = new ArrayList<>();        
        Map<Integer, Set<Integer>> reqSet = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            reqSet.put(i, new HashSet<>());
        }
        for (int[] r : prerequisites) {
            indegree[r[1]]++;
            graph.get(r[0]).add(r[1]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) if (indegree[i] == 0) queue.offer(i);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int nbr : graph.get(curr)) {
                reqSet.get(nbr).add(curr);
                reqSet.get(nbr).addAll(reqSet.get(curr));
                indegree[nbr]--;
                if (indegree[nbr] == 0) queue.add(nbr);
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) {
            res.add(reqSet.get(q[1]).contains(q[0]));
        }
        return res;
    }
}
