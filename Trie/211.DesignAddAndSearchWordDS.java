class Node {
    Node[] children;
    boolean end;
    public Node() {
        children = new Node[26];
        end = false;
    }
}

class WordDictionary {
    Node root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] == null) {
                curr.children[word.charAt(i) - 'a'] = new Node();
            }
            curr = curr.children[word.charAt(i) - 'a'];
        }
        curr.end = true;
    }
    
    public boolean search(String word) {
        return dfs(root, word, 0);
    }
    
    public boolean dfs(Node curr, String word, int index) {
        if (curr == null) {
            return false;
        }
        if (index == word.length()) {
            return curr.end;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (dfs(curr.children[i], word, index + 1)) {
                    return true;
                }
            }
        } else {
            if (dfs(curr.children[c - 'a'], word, index + 1)) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
