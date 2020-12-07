class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<String> stack = new LinkedList<>();
        int count = 0;
        int[] res = new int[n];
        for (String log : logs) {
            String[] info = log.split(":");
            if (info[1].equals("start")) {
                stack.addFirst(log);
            } else {
                String[] startInfo = stack.removeFirst().split(":");
                res[Integer.valueOf(startInfo[0])] += Integer.valueOf(info[2]) - Integer.valueOf(startInfo[2]) + 1;
                if (!stack.isEmpty()) {
                    String[] prevInfo = stack.peek().split(":");
                    res[Integer.valueOf(prevInfo[0])] -= Integer.valueOf(info[2]) - Integer.valueOf(startInfo[2]) + 1;
                }
            }
        }
        return res;
    }
}
