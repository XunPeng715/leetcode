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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.val == targetSum) {
            count++;
        }
        return count + pathSum(root.left, targetSum) + 
            pathSum(root.right, targetSum) + 
            pathSumWithCurr(root.left, targetSum - root.val) + 
            pathSumWithCurr(root.right, targetSum - root.val);
    }
    
    public int pathSumWithCurr(TreeNode node, int target) {
        if (node == null) return 0;
        int count = 0;
        if (node.val == target) {
            count++;
        }
        return count + pathSumWithCurr(node.left, target - node.val) + pathSumWithCurr(node.right, target - node.val);        
    }
}
