class Solution {
    public int calculate(String s) {
        int i = 0;
        Deque<String> stack = new LinkedList();
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '(' ||  s.charAt(i) == '+' || s.charAt(i) == '-') {
                stack.addFirst(Character.toString(s.charAt(i)));
                i++;
            } else if (Character.isDigit(s.charAt(i))) {
                int start = i;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                stack.addFirst(s.substring(start, i));
            } else {
                int sum = 0;
                String ope = ")";
                while (!ope.equals("(")) {
                    int val = Integer.valueOf(stack.removeFirst());
                    ope = stack.removeFirst();
                    if (ope.equals("+") || ope.equals("(")) sum += val;
                    else if (ope.equals("-")) sum -= val;
                }
                stack.addFirst(Integer.toString(sum));
                i++;
            }
        }
        int res = 0;
        res += Integer.valueOf(stack.removeLast());
        while (!stack.isEmpty()) {
            int val = Integer.valueOf(stack.removeFirst());
            String ope = stack.removeFirst();
            if (ope.equals("+")) res += val;
            else if (ope.equals("-")) res -= val;
        }
        return res;
    }
}
