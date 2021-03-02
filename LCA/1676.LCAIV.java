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
    TreeNode result =  null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> set = new HashSet<>();
        for (TreeNode node: nodes) set.add(node);
        helper(root, set);
        return result;
    }
    
    public int helper(TreeNode root, Set<TreeNode> set) {
        if (root == null || result != null) {
            return 0;
        }
        int count = set.contains(root) ? 1 : 0;
        count += helper(root.left, set);
        count += helper(root.right, set);
        
        if (count == set.size() && result == null) {
            result = root;
        }
        return count;
    }
}
