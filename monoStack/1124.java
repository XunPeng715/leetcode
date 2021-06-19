class Solution {
    public int longestWPI(int[] hours) {
        Map<Integer, Integer> firstOccur = new HashMap<>();
        int res = 0, curr = 0;
        for (int i = 0; i < hours.length; i++) {
            curr += hours[i] > 8 ? 1 : -1;
            if (curr >= 1) {
                res = i + 1;
            } else {
                if (firstOccur.containsKey(curr - 1)) {
                    res = Math.max(res, i - firstOccur.get(curr - 1));
                }
                firstOccur.putIfAbsent(curr, i);
            }
        }
        return res;
    }
}
