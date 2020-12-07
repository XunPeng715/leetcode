class Solution {
    public String removeKdigits(String num, int k) {
        int m = num.length() - k;
        char[] tmp = new char[m];
        char[] nums = num.toCharArray();
        Deque<Character> deq = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            char c = nums[i];
            while (!deq.isEmpty() && deq.peek() > c) {
                deq.removeFirst();
            }
            deq.addFirst(c);
            if (i >= k) tmp[i - k] = deq.removeLast();
        }
        int i = 0;
        for (i = 0; i < m; i++) {
            if (tmp[i] != '0') break;
        }
        if (i == m) return "0";
        char[] res = new char[m - i];
        for (int j = i; j < m; j++) res[j - i] = tmp[j];
        return new String(res);
    }
}
