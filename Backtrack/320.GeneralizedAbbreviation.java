class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), 0, word, false, false);
        return res;
    }
    
    public void dfs(List<String> res, StringBuilder sb, int index, String word, boolean isDigit, boolean isLetter) {
        if (index == word.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = 1; i <= word.length() - index; i++) {
            if (!isDigit) {                
                sb.append(i);
                dfs(res, sb, index + i, word, true, false);
                String s = String.valueOf(i);
                sb.setLength(sb.length() - s.length());                
            }
            if (!isLetter) {
                sb.append(word.substring(index, index + i));
                dfs(res, sb, index + i, word, false, true);
                sb.setLength(sb.length() - i);
            }            
        }
    }
}
