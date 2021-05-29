class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '-' || c == '*' || c == '+') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1, expression.length()));
                for (int m : left) {
                    for (int n : right) {
                        if (c == '-') {
                            res.add(m - n);
                        } else if (c == '+') {
                            res.add(m + n);
                        } else {
                            res.add(m * n);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(expression));
        }
        return res;
    }
}
