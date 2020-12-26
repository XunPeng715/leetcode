class Solution {
    // Solution: sliding windows
    public int longestSubstring(String s, int k) {
        int res = 0;
        for (int n = 1; n <= 26; n++) {
            int uniqCount = 0;
            int achieve = 0;
            int j = 0;
            int[] counts = new int[26];
            for (int i = 0; i < s.length(); i++) {
                counts[s.charAt(i) - 'a']++;
                if (counts[s.charAt(i) - 'a'] == 1) uniqCount++;
                if (counts[s.charAt(i) - 'a'] == k) achieve++;
                while (uniqCount > n) {
                    counts[s.charAt(j) - 'a']--;
                    if (counts[s.charAt(j) - 'a'] == 0) uniqCount--;
                    if (counts[s.charAt(j) - 'a'] == k - 1) achieve--;
                    j++;
                }
                if (uniqCount == n && achieve == n) {
                    res = Math.max(res, i - j + 1);
                }
            }            
        }
        return res;
    }
    // Solution: dfs
    public int longestSubstring1(String s, int k) {
        if (k == 1) return s.length();
        return dfs(s, 0, s.length() - 1, k);
    }
    
    public int dfs(String s, int start, int end, int k) {
        if (start >= end) {
            return 0;
        }
        int[] counts = new int[26];
        for (int i = start; i <= end; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] >= k) continue;
            for (int j = start; j <= end; j++) {
                if (s.charAt(j) - 'a' == i) {
                    return Math.max(dfs(s, start, j - 1, k), dfs(s, j + 1, end, k));
                }
            }
        }
        return end - start + 1;
    }
}
