# 1023. Camelcase Matching
class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String query : queries) {
            int i = 0;
            int j = 0;
            while (j < pattern.length() || i < query.length()) {
                if (i == query.length()) {
                    res.add(false);
                    break;
                } else if (j == pattern.length() || query.charAt(i) != pattern.charAt(j)) {
                    if (Character.isUpperCase(query.charAt(i))) {
                        res.add(false);
                        break;
                    }
                } else {
                    j++;
                }
                i++;
            }
            if (i == query.length() && j == pattern.length()) {
                res.add(true);
            }            
        }
        return res;
    }
}

