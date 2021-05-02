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
    int max = 1;
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        // count, isBST, largest, smallest
        dfs(root);
        return max;
    }
    
    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 1, Integer.MIN_VALUE, Integer.MAX_VALUE};
        }
        
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int n = 1 + left[0] + right[0];
        if (left[1] == 0 || right[1] == 0) {
            return new int[]{n, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        if (node.val <= left[2] || node.val >= right[3]) {
            return new int[]{n, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        System.out.print(n);
        max = Math.max(max, n);
        return new int[]{n, 1, Math.max(node.val, right[2]), Math.min(node.val, left[3])};
    }
}
