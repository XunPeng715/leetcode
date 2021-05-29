class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[] start = new int[26];
        int[] end = new int[26];
        Arrays.fill(start, -1);
        Arrays.fill(end, -1);
        for (int i = 0; i < s.length(); i++) {
            if (start[s.charAt(i) - 'a'] == -1) {
                start[s.charAt(i) - 'a'] = i;
            }
            end[s.charAt(i) - 'a'] = i;
        }
        List<int[]> validList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (start[i] == -1)
                continue;
            int left = start[i], right = end[i];
            boolean isValid = true;
            for (int j = left; j <= right; j++) {
                if (start[s.charAt(j) - 'a'] < left) {
                    isValid = false;
                    break;
                }
                right = Math.max(right, end[s.charAt(j) - 'a']);
            }
            if (isValid)
                validList.add(new int[]{left, right});
        }
        int[] valid = new int[validList.size()];
        for (int i = 0; i < validList.size(); i++) {
            for (int j = 0; j < validList.size(); j++) {
                if (validList.get(i)[0] < validList.get(j)[0] && validList.get(i)[1] > validList.get(j)[1]) {
                    valid[i] = -1;
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < valid.length; i++) {
            if (valid[i] == 0) {
                res.add(s.substring(validList.get(i)[0], validList.get(i)[1] + 1));
            }
        }        
        return res;
    }
}
