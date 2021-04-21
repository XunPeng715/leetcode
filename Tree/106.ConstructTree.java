/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    public TreeNode helper(int[] inorder, int s1, int e1, int[] postorder, int s2, int e2) {
        if (s1 > e1) return null;
        int val = postorder[e2], i = s1;
        while (inorder[i] != val) {
            i++;
        }
        TreeNode left = helper(inorder, s1, i - 1, postorder, s2, s2 + i - s1 - 1);
        TreeNode right = helper(inorder, i + 1, e1, postorder, s2 + i - s1, e2 - 1);
        return new TreeNode(val, left, right);
    }
}
