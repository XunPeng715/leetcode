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
    public TreeNode recoverFromPreorder(String S) {
        return dfs(S, 0, S.length() - 1);
    }
    
    public TreeNode dfs(String S, int start, int end) {
        if (start > end) return null;
        int i = start;
        while (i <= end && S.charAt(i) != '-') {
            i++;
        }
        int val = Integer.valueOf(S.substring(start, i));
        if (i > end) return new TreeNode(val);
        int level = 0;
        while (i <= end && S.charAt(i) == '-') {
            level++;
            i++;
        }
        int leftStart = i, currLevel = 0;
        while (i <= end) {
            if (S.charAt(i) != '-') {
                if (currLevel == level) break;
                currLevel = 0;                
            } else {
                currLevel++;
            }
            i++;
        }
 
        TreeNode left = dfs(S, leftStart, i - level - 1);
        TreeNode right = dfs(S, i, end);
        return new TreeNode(val, left, right);
    }
}
