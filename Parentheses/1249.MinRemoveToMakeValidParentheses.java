class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Character> deq = new LinkedList<>();
        int openCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openCount++;
            } else if (c == ')') {
                if (openCount == 0) {
                    continue;
                }
                openCount--;
            }
            deq.offer(c);
        }
        StringBuilder sb = new StringBuilder();
        int closeCount = 0;
        while (!deq.isEmpty()) {
            char c = deq.removeLast();
            if (c == ')') {
                closeCount++;
            } else if (c == '(') {
                if (closeCount == 0) {
                    continue;
                }
                closeCount--;
            }
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
