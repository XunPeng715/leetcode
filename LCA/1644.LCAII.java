/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return result;
    }
    
    public int helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return 0;
        int count = (root == q || root == p) ? 1 : 0;
        count += helper(root.left, p, q);
        count += helper(root.right, p, q);
        if (count == 2 && result == null) {
            result = root;
        }
        return count;
    }
}
