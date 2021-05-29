class Solution {
    public int longestAwesome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c = '0'; c <= '9'; c++) {
            map.put(c, (int) Math.pow(2, c - '0'));
        }
        Map<Integer, Integer> evenFirstOcur = new HashMap<>();
        Map<Integer, Integer> oddFirstOcur = new HashMap<>();
        oddFirstOcur.put(0, -1);
        int curr = 0, max = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            curr ^= map.get(c);
            if (i % 2 == 1) {
                if (!oddFirstOcur.containsKey(curr)) {
                    oddFirstOcur.put(curr, i);
                }
                max = Math.max(max, i - oddFirstOcur.get(curr));
                for (char candidate = '0'; candidate <= '9'; candidate++) {
                    curr ^= map.get(candidate);
                    if (evenFirstOcur.containsKey(curr)) {
                        max = Math.max(max, i - evenFirstOcur.get(curr));
                    }
                    curr ^= map.get(candidate);
                } 
            } else {
                if (!evenFirstOcur.containsKey(curr)) {
                    evenFirstOcur.put(curr, i);
                }
                max = Math.max(max, i - evenFirstOcur.get(curr));
                for (char candidate = '0'; candidate <= '9'; candidate++) {
                    curr ^= map.get(candidate);
                    if (oddFirstOcur.containsKey(curr)) {
                        max = Math.max(max, i - oddFirstOcur.get(curr));
                    }
                    curr ^= map.get(candidate);
                } 
            }
        }
        return max;
    }
}
