class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        int j = 0;
        Deque<Integer> stack = new LinkedList<>();
        while (j < popped.length) {
            while (stack.isEmpty() || stack.peek() != popped[j]) {
                if (i == pushed.length) return false;
                stack.addFirst(pushed[i]);
                i++;
            }
            stack.removeFirst();
            j++;
        }
        return true;
    }
}
