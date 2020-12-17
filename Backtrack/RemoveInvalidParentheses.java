class Solution {
    Set<String> res = new HashSet<>();
    int max = 0;
    public List<String> removeInvalidParentheses(String s) {
        dfs(s, new StringBuilder(), 0, 0, 0);
        List<String> strs = new ArrayList<>();
        for (String str : res) strs.add(str);
        return strs;
    }
    
    public void dfs(String s, StringBuilder sb, int i, int open, int close) {        
        if (open == close) {
            if (sb.length() == max) {
                res.add(sb.toString());
            } else if (sb.length() > max) {
                max = sb.length();
                res = new HashSet();
                res.add(sb.toString());
            }
        }
        if (i == s.length()) {
            return;
        }
        if (s.charAt(i) == '(') {
            sb.append(s.charAt(i));
            dfs(s, sb, i + 1, open + 1, close);
            sb.setLength(sb.length() - 1);
            dfs(s, sb, i + 1, open, close);
        } else if (s.charAt(i) == ')') {
            if (open > close) {
                sb.append(s.charAt(i));
                dfs(s, sb, i + 1, open, close + 1);
                sb.setLength(sb.length() - 1);
            }
            dfs(s, sb, i + 1, open, close);            
        } else if (Character.isLetter(s.charAt(i))) {
            sb.append(s.charAt(i));
            dfs(s, sb, i + 1, open, close);
            sb.setLength(sb.length() - 1);
        }
    }
}
