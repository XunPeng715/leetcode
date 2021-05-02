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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        dfs(root, targetSum - root.val, list);
        return res;
    }
    
    public void dfs(TreeNode node,int targetSum, List<Integer> list) {
        if (node.left == null && node.right == null) {
            if (targetSum == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if (node.left != null) {
            list.add(node.left.val);
            dfs(node.left, targetSum - node.left.val, list);
            list.remove(list.size() - 1);            
        }
        if (node.right != null) {
            list.add(node.right.val);
            dfs(node.right, targetSum - node.right.val, list);
            list.remove(list.size() - 1);  
        }
    }
}
