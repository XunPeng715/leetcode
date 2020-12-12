// 285. Inorder Successor in BST
// 1. general solution for Successor in all tree
//    a. recursion b. iteration
// 2. general solution for Predecessor in all tree
//    a. almost the same with precessor
// 3. general solution for Successor in BST
// 4. general solution for Predecessor in BST
// TODO: using iteration
class Solution {
    TreeNode preVisit = null;
    TreeNode res = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root, p);
        return res;
    }
    
    // 1. general solution for Successor in all tree
    public void dfs(TreeNode root, TreeNode p) {
        if (root.left != null) {
            dfs(root.left, p);
        }
        if (preVisit == p) {
            res = root;
        }
        preVisit = root;
        if (root.right != null) {
            dfs(root.right, p);
        }
    }
    // 2. general solution for Predecessor in all tree
    public void dfs1(TreeNode root, TreeNode p) {
        if (root.left != null) {
            dfs(root.left, p);
        }
        if (root == p) {
            res = preVisit;
        }
        preVisit = root;
        if (root.right != null) {
            dfs(root.right, p);
        }
    }
    // 3. general solution for Successor in BST
    public TreeNode inorderPredecessor1(TreeNode root, TreeNode p) {
        TreeNode suc = null;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val > p.val) {
                suc = curr;
                curr = curr.left;                
            } else {
                curr = curr.right;
            }
        }
        return suc;
    }
    // 4. general solution for Predecessor in BST
    public TreeNode inorderPredecessor2(TreeNode root, TreeNode p) {
        TreeNode pre = null;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val >= p.val) {                
                curr = curr.left;                
            } else if (curr.val < p.val) {
                pre = curr;
                curr = curr.right;
            }
        }
        return pre;
    }
} 




// 510. Inorder Successor in BST II
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
    public Node inorderSuccessor(Node node) {
        // 1. find the left most node in right subtree
        // 2. find the left parent larger than node
        if (node.right != null) {
            Node curr = node.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        } else if (node.parent != null) {
            Node curr = node.parent;
            while (curr != null && curr.val < node.val) {
                curr = curr.parent;
            } 
            return curr;
        }
        return null;
    }
}
