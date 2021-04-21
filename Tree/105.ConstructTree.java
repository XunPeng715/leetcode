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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, preorder.length - 1);
    }
    
    public TreeNode helper(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2) {
        if (s1 > e1) return null;
        int val = preorder[s1];
        int i = s2;
        while (inorder[i] != val)
            i++;
        TreeNode left = helper(preorder, s1 + 1, s1 + i - s2, inorder, s2, i - 1);
        TreeNode right = helper(preorder, s1 + i + 1 - s2, e1, inorder, i + 1, e2);
        return new TreeNode(val, left, right);
    }
}
