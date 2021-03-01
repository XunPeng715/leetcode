class Node {
    Node[] children;
    public Node() {
        children = new Node[2];
    }
}
class Solution {    
    Node root = new Node();
    public void add(int num) {
        Node curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
			if (curr.children[bit] == null){
                curr.children[bit] = new Node();
            }
			curr = curr.children[bit];
        }
    }
    
    public int search(int num) {
        Node curr = root;
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            int k = (num >> i) & 1;
            if (curr.children[k ^ 1] != null) {
                res = res * 2 + 1;
                curr = curr.children[k ^ 1];
            } else {
                res = res * 2;
                curr = curr.children[k];
            }
        }
        return res;
    }

    public int findMaximumXOR(int[] nums) {        
        for (int num : nums) {
            add(num);
        }
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, search(num));            
        }
        return max;
    }
}
