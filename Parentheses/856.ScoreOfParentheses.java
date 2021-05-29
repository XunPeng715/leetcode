class Solution {
    public int scoreOfParentheses(String s) {
        Deque<String> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i, i + 1);
            if (c.equals("(")) {
                stack.addFirst(c);
            } else {
                int sum = 0;
                String curr = stack.removeFirst();
                while (!curr.equals("(")) {
                    sum += Integer.valueOf(curr);
                    curr = stack.removeFirst();
                }
                sum = sum == 0 ? 1 : sum * 2;
                stack.addFirst(Integer.toString(sum));
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += Integer.valueOf(stack.removeFirst());
        }
        return res;
    }
}
