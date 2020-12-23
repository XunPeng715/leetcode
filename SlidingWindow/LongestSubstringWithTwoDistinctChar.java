class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        int j = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0) + 1);
            while (counts.size() > 2) {
                counts.put(s.charAt(j), counts.get(s.charAt(j)) - 1);
                if (counts.get(s.charAt(j)) == 0) {
                    counts.remove(s.charAt(j));
                }
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
