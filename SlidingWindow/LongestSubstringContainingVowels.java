class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Character, Integer> mask = new HashMap<>();
        Map<Integer, Integer> seen = new HashMap<>();
        mask.put('a', 1);
        mask.put('e', 2);
        mask.put('i', 4);
        mask.put('o', 8);
        mask.put('u', 16);        
        int res = 0, curr = 0;
        seen.putIfAbsent(0, -1);
        for (int i = 0; i < s.length(); i++) {
            if (mask.containsKey(s.charAt(i))) {
                curr ^= mask.get(s.charAt(i));
            }
            if (seen.containsKey(curr)) {
                res = Math.max(res, i - seen.get(curr));
            }
            seen.putIfAbsent(curr, i);
        }
        return res;
    }
}
