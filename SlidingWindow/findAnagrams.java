class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            counts.put(p.charAt(i), counts.getOrDefault(p.charAt(i), 0) - 1);
            if (counts.get(p.charAt(i)) == 0) counts.remove(p.charAt(i));
            counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0) + 1);
            if (counts.get(s.charAt(i)) == 0) counts.remove(s.charAt(i));
        }        
        if (counts.size() == 0) res.add(0);
        for (int i = 0; i < s.length() - p.length(); i++) {
            counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0) - 1);
            if (counts.get(s.charAt(i)) == 0) counts.remove(s.charAt(i));
            counts.put(s.charAt(i + p.length()), counts.getOrDefault(s.charAt(i + p.length()), 0) + 1);
            if (counts.get(s.charAt(i + p.length())) == 0) counts.remove(s.charAt(i + p.length()));
            if (counts.size() == 0) res.add(i + 1);
        }
        return res;
    }
}
