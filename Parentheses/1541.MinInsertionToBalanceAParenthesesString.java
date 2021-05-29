class Solution {
    public int minInsertions(String s) {
        int res = 0, open = 0, i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(') {
                i++;
                open++;
            } else {
                i++;
                if (i == s.length() || s.charAt(i) == '(') {
                    res++;
                    if (open == 0) {
                        res++;
                    } else {
                        open--;
                    }
                } else {
                    if (open == 0) {
                        res++;
                    } else {
                        open--;
                    }
                    i++;
                }
            }            
        }
        return res + open * 2;
    }
}
