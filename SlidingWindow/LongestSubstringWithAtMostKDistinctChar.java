class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int j = 0;
        int res = 0;
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0) + 1);
            while (counts.size() > k) {
                counts.put(s.charAt(j), counts.get(s.charAt(j)) - 1);
                if (counts.get(s.charAt(j)) == 0) counts.remove(s.charAt(j));
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
