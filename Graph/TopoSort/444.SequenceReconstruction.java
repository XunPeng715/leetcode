class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, List<Integer>> nbrs = new HashMap<>();
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                if (!nbrs.containsKey(seq.get(i))) {
                    nbrs.put(seq.get(i), new ArrayList<>());
                }
                if (i == 0) {
                    indegree.put(seq.get(i), indegree.getOrDefault(seq.get(i), 0));
                } else {                  
                    nbrs.get(seq.get(i - 1)).add(seq.get(i));
                    indegree.put(seq.get(i), indegree.getOrDefault(seq.get(i), 0) + 1);
                }                
            }
        }
        if (indegree.size() != org.length) return false;
        Queue<Integer> queue = new LinkedList<>();
        for (int i : indegree.keySet()) {
            if (indegree.get(i) == 0) queue.offer(i);
        }
        int j = 0;
        while (!queue.isEmpty()) {
            if (queue.size() != 1) {
                return false;
            }
            int curr = queue.poll();
            if (j == org.length || org[j++] != curr) {
                return false;
            }
            for (int nbr : nbrs.get(curr)) {
                indegree.put(nbr, indegree.get(nbr) - 1);
                if (indegree.get(nbr) == 0) {
                    queue.offer(nbr);
                }
            }
        }
        return j == org.length;
    }
}
