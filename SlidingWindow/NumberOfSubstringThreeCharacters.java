class Solution {
    public int numberOfSubstrings(String s) {
        int j = 0, count = 0, res = 0;
        int[] counts = new int[3];
        for (int i  = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            if (counts[s.charAt(i) - 'a'] == 1) count++;
            while (count == 3 && counts[s.charAt(j) - 'a'] > 1) {
                counts[s.charAt(j) - 'a']--;
                j++;
            }
            if (count == 3) res += j + 1; 
        }
        return res;
    }
}
