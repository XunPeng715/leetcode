class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, List<Character>> nbrs = new HashMap<>();
        for (String w : words) {
            for (int i = 0; i < w.length(); i++) {
                indegree.put(w.charAt(i), 0);
            }
        }
        for (int i = 1; i < words.length; i++) {
            String w1 = words[i - 1];
            String w2 = words[i];
            int j = 0;
            for (j = 0; j < Math.min(w1.length(), w2.length()); j++) {                
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (!nbrs.containsKey(w1.charAt(j))) {
                        nbrs.put(w1.charAt(j), new ArrayList<>());
                    }                    
                    nbrs.get(w1.charAt(j)).add(w2.charAt(j));
                    indegree.put(w2.charAt(j), indegree.get(w2.charAt(j)) + 1);
                    break;
                }
            }
            if (j == w2.length() && w1.length() > w2.length()) return "";
        }
        Queue<Character> queue = new LinkedList<>();
        for (char c : indegree.keySet()) if (indegree.get(c) == 0) queue.offer(c);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            sb.append(curr);
            if (!nbrs.containsKey(curr)) {
                continue;
            }
            for (char nbr : nbrs.get(curr)) {
                indegree.put(nbr, indegree.get(nbr) - 1);
                if (indegree.get(nbr) == 0) {
                    queue.offer(nbr);
                }
            }
        }
        return sb.length() == indegree.size() ? sb.toString(): "";
    }
}
