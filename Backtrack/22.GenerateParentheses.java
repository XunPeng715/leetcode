class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, 0, 0, new StringBuilder(), n);
        return res;
    }
    
    public void dfs(List<String> res, int open, int close, StringBuilder sb, int n) {
        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append("(");
            dfs(res, open + 1, close, sb, n);
            sb.setLength(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            dfs(res, open, close + 1, sb, n);
            sb.setLength(sb.length() - 1);
        }
    }
}
