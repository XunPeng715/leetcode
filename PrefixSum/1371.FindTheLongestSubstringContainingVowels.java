class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('e', 2);
        map.put('i', 4);
        map.put('o', 8);
        map.put('u', 16);
        Map<Integer, Integer> firstOcur = new HashMap<>();
        int curr = 0, res = 0;
        firstOcur.put(curr, -1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                curr ^= map.get(c);
            }
            if (!firstOcur.containsKey(curr)) {
                firstOcur.put(curr, i);
            }
            res = Math.max(res, i - firstOcur.get(curr));
        }
        return res;
    }
}
