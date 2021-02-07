class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});        
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});        
        dfs(res, new StringBuilder(), digits, 0, map);
        return res;
    }
    
    public void dfs(List<String> res, StringBuilder sb, String digits, int digitIndex, Map<Character, char[]> map) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char d = digits.charAt(digitIndex);
        char[] chars = map.get(d);
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
            dfs(res, sb, digits, digitIndex + 1, map);
            sb.setLength(sb.length() - 1);
        }
    }
}
