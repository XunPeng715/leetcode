class Node {
    Node[] children;
    int index;
    public Node() {
        children = new Node[26];
        index = -1;
    }
}
class WordFilter {
    Node root = null;
    public WordFilter(String[] words) {
        root = new Node();
        Node curr = root;
        for (int i = 0; i < words.length; i++) {
            addNode(words[i], root, i);
        }
    }
    
    public int f(String prefix, String suffix) {
        Node curr = root;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curr.children[c - 'a'] == null) {
                return -1;
            }
            list.add(c);
            curr = curr.children[c - 'a'];
        }        
        return dfs(curr, list, suffix);
    }
    
    public int dfs(Node node, List<Character> list, String suffix) {
        
        if (node == null) return -1;
        int res = node.index;        
        for (int i = 0; i < suffix.length(); i++) {
            if (list.size() - 1 - i < 0 || (list.get(list.size() - 1 - i) != suffix.charAt(suffix.length() - i - 1))) {
                res = -1;
                break;
            }
        }
        for (char c = 'a'; c <= 'z'; c++) {
            Node child = node.children[c - 'a'];
            list.add(c);
            res = Math.max(res, dfs(child, list, suffix));
            list.remove(list.size() - 1);
        }
        return res;
    }
    
    public void addNode(String word, Node node, int index) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new Node();
            }
            node = node.children[c - 'a'];
        }
        node.index = index;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
