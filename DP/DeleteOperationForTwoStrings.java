class Solution {
    public int minDistance(String word1, String word2) {
        return dfs(word1, word2, new HashMap<String, Integer>());
    }
    
    public int dfs(String s1, String s2, Map<String, Integer> memo) {
        if (s1.length() == 0) {
            return s2.length();
        } else if (s2.length() == 0) {
            return s1.length();
        }
        String key = s1 + "," + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int res = 0;
        if (s1.charAt(0) == s2.charAt(0)) {
            res = dfs(s1.substring(1, s1.length()), s2.substring(1, s2.length()), memo);
        } else {
            res = Math.min(dfs(s1, s2.substring(1, s2.length()), memo), dfs(s1.substring(1, s1.length()), s2, memo)) + 1;
        }
        memo.put(key, res);
        return res;
    }
}
