class Solution {
    public int balancedString(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }
        //[j, i]
        int j = 0, res = s.length(), n = s.length();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count.put(c, count.get(c) - 1);
            while (j <= Math.min(i + 1, n - 1) && 
                   count.getOrDefault('Q', 0) <= n / 4 &&
                   count.getOrDefault('W', 0) <= n / 4 &&
                   count.getOrDefault('E', 0) <= n / 4 &&
                   count.getOrDefault('R', 0) <= n / 4) {
                res = Math.min(res, i - j + 1);
                c = s.charAt(j);
                count.put(c, count.get(c) + 1);
                j++;
            }
        }
        return res;
    }
}
