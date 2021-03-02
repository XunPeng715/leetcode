/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> visited = new HashSet<>();
        while (p != null || q != null) {
            if (p != null) {
                if (visited.contains(p)) {
                    return p;
                } 
                visited.add(p);
                p = p.parent;
            }
            
            if (q != null) {
                if (visited.contains(q)) {
                    return q;
                }
                visited.add(q);            
                q = q.parent;                
            }
        }
        return null;
    }
}
