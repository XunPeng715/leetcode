class Solution {
    public boolean checkValidString(String s) {
        Deque<String> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '*') {
                if (stack.isEmpty() || stack.getFirst().equals("(")) {
                    stack.addFirst("1");
                } else {
                    int count = Integer.valueOf(stack.removeFirst());
                    stack.addFirst(Integer.toString(count + 1));
                }
            } else if (curr == '(') {
                stack.addFirst("(");
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.getFirst().equals("(")) {
                    stack.removeFirst();
                } else if (stack.size() == 1) {
                    int count = Integer.valueOf(stack.removeFirst());
                    if (count > 1)
                        stack.addFirst(Integer.toString(count - 1));
                } else if (stack.size() == 2) {
                    String count = stack.removeFirst();
                    stack.removeFirst();
                    stack.addFirst(count);
                } else {
                    int count1 = Integer.valueOf(stack.removeFirst());
                    stack.removeFirst();
                    if (!stack.getFirst().equals("(")) {
                        int count2 = Integer.valueOf(stack.removeFirst());
                        stack.addFirst(Integer.toString(count1 + count2));
                    } else {
                        stack.addFirst(Integer.toString(count1));
                    }                    
                }
            }
        }
        int openCount = 0;
        while (!stack.isEmpty()) {
            String curr = stack.removeLast();
            if (curr.equals("(")) {
                openCount++;
            } else {
                int count = Integer.valueOf(curr);
                if (count < openCount) {
                    openCount -= count;
                } else {
                    openCount = 0;
                }
            }
        }
        return openCount == 0;
    }
}
