class Count {
    char c;
    int count;
    public Count(char c, int count) {
        this.c = c;
        this.count = count;
    }
}
class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<Count> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || stack.peek().c != c) {
                stack.addFirst(new Count(c, 1));
            } else {
                stack.peek().count += 1;
                if (stack.peek().count == k) {
                    stack.removeFirst();
                }
            }
        }
        List<Count> list = new ArrayList<>();
        while (!stack.isEmpty()) list.add(stack.removeFirst());
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            for (int j = 0; j < list.get(i).count; j++) {
                sb.append(list.get(i).c);
            }
        }
        return sb.toString();
    }
}
