# 76. Minimum Window Substring
class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        if (s.length() < t.length()) {
            return res;
        }
        int min = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int count = map.size();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == 0) count--;
            }
            while (j <= i && count == 0) {
                if (i - j + 1 <= min) {
                    res = s.substring(j, i + 1);
                    min = Math.min(min, i + 1 - j);
                }
                if (map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                    if (map.get(s.charAt(j)) == 1) count++;
                }
                j++;
            }
        }
        return res;
    }
}
