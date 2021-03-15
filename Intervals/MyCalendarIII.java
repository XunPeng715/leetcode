class MyCalendarThree {
    
    TreeMap<Integer, Integer> treeMap;
    public MyCalendarThree() {
        treeMap = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        int max = 0, count = 0;
        treeMap.put(start, treeMap.getOrDefault(start, 0) + 1);
        treeMap.put(end, treeMap.getOrDefault(end, 0) - 1);
        for (int key : treeMap.keySet()) {
            count += treeMap.get(key);
            max = Math.max(count, max);
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
