class StockSpanner {
    List<Integer> prices;
    Deque<Integer> stack;
    public StockSpanner() {
        prices = new ArrayList<>();
        stack = new LinkedList<>();
    }
    // find last day with higher price
    public int next(int price) {
        prices.add(price);
        while (!stack.isEmpty() && prices.get(stack.peek()) <= price) {
            stack.removeFirst();
        }
        int res = stack.isEmpty() ? prices.size() : prices.size() - stack.peek() - 1;
        stack.addFirst(prices.size() - 1);
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
