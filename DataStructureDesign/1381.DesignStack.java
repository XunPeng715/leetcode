class CustomStack {
    Deque<Integer> stack;
    Map<Integer, Integer> map;
    int MAX;
    public CustomStack(int maxSize) {
        stack = new LinkedList<>();
        map = new HashMap <>();
        MAX = maxSize;
    }
    
    public void push(int x) {
        if (stack.size() == MAX) {
            return;
        }
        stack.addFirst(x);
    }
    
    public int pop() {
        int size = stack.size();
        if (size == 0) return -1;
        int val = stack.removeFirst();
        if (map.containsKey(size)) {
            val += map.get(size);
            map.put(size - 1, map.getOrDefault(size - 1, 0) + map.get(size));
            map.remove(size);
        }
        return val;
    }
    
    public void increment(int k, int val) {
        int size = stack.size();
        if (k >= stack.size()) {
            map.put(size, map.getOrDefault(size, 0) + val);
        } else {
            map.put(k, map.getOrDefault(k, 0) + val);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
