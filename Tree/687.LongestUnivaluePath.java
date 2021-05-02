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
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        int[] res = dfs(root);
        return res[1] - 1;
    }
    // anyToRoot, anyToAny
    public int[] dfs(TreeNode node) {
        int[] res = new int[2];
        if (node == null) {
            return res;
        }
        
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        res[0] = 1;
        res[1] = 1;
        if (node.left != null && node.val == node.left.val) {
            res[0] = left[0] + 1;
            res[1] = res[0];
        }
        if (node.right != null && node.val == node.right.val) {
            res[0] = Math.max(res[0], right[0] + 1);
            res[1] += right[0];
        }
        res[1] = Math.max(res[1], Math.max(left[1], right[1]));
        return res;
    }
}
