class Solution {
    int min = Integer.MAX_VALUE;
    String res = "";
    public String minAbbreviation(String target, String[] dictionary) {
        generateAbb(dictionary, target, 0, new StringBuilder(), 0, false, false);
        return res;
    }
    
    public void generateAbb(String[] dictionary, String word, int index, StringBuilder sb, int length, boolean digit, boolean letter) {
        if (index == word.length()) {
            if (length < min) {
                String s = sb.toString();
                if (valid(s, dictionary)) {
                    min = length;
                    res = s;
                }        
            }
        }
        for (int i = index; i < word.length(); i++) {
            // letter
            if (!letter) {
                String tmp = word.substring(index, i + 1);
                sb.append(word.substring(index, i + 1));
                generateAbb(dictionary, word, i + 1, sb, length + i - index + 1, false, true);
                sb.setLength(sb.length() - tmp.length());
            }            
            // digit
            if (!digit) {
                String tmp = String.valueOf(i + 1 - index);
                sb.append(tmp);
                generateAbb(dictionary, word, i + 1, sb, length + 1, true, false);
                sb.setLength(sb.length() - tmp.length());                
            }
        }
    }
    
    public boolean valid(String abbr, String[] dictionary) {
        for (String word : dictionary) {
            int i = 0, j = 0, l = 0;
            while (i < word.length() && j < abbr.length()) {
                if (abbr.charAt(j) == '0') {
                    return false;
                }
                while (j + l < abbr.length() && Character.isDigit(abbr.charAt(j + l))) {
                    l++;
                }
                if (l == 0) {
                    if (word.charAt(i) != abbr.charAt(j)) break;
                    i++;
                    j++;
                } else {
                    int count = Integer.parseInt(abbr.substring(j, j + l));
                    j += l;
                    i += count;
                }
                l = 0;
            }
            if (i == word.length() && j == abbr.length()) {
                return false;
            }         
        }
        return true;
    }
}
