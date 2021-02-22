class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String str : wordDict) set.add(str);
        Map<Integer, List<List<String>>> memo = new HashMap<>();     
        List<List<String>> list = dfs(set, s, 0, memo);
        List<String> res = new ArrayList<>();
        for (List<String> l : list) {
            Collections.reverse(l);
            res.add(String.join(" ", l));
        }
        return res;
    }
    
    public List<List<String>> dfs(Set<String> set, String s, int index, Map<Integer, List<List<String>>> memo) {
        if (index == s.length()) {
            List<List<String>> list = new ArrayList<>();
            list.add(new ArrayList<>());
            return list;
        }
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        List<List<String>> list = new ArrayList<>();
        for (int i = index + 1; i <= s.length(); i++) {
            String curr = s.substring(index, i);
            if (!set.contains(curr)) {
                continue;
            }
            List<List<String>> dependencies = dfs(set, s, i, memo);
            List<List<String>> res = new ArrayList<>();
            for (List<String> d : dependencies) {
                List<String> solution = new ArrayList<>(d);
                solution.add(curr);
                res.add(solution);
            }
            list.addAll(res);
        }
        memo.put(index, list);
        return list;
    }
}
