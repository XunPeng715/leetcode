class Solution {
    public int[] dailyTemperatures1(int[] T) {
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            int t = T[i];
            while (!stack.isEmpty() && stack.peek() <= t) {
                map.remove(stack.removeFirst());
            }
            res[i] = stack.isEmpty() ? 0 : map.get(stack.peek()) - i;
            stack.addFirst(t);
            map.put(t, i);
        }
        return res;
    }
    
    // optimization: no map
    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            int t = T[i];
            while (!stack.isEmpty() && T[stack.peek()] <= t) {
                stack.removeFirst();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.addFirst(i);
        }
        return res;
    }
} 
