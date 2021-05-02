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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        updateParents(root, parents);
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        visited.add(target);
        queue.offer(target);
        List<Integer> res = new LinkedList<>();
        int level = 0;
        while (!queue.isEmpty()) {
            if (level > K) break;
            int size = queue.size();            
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (level == K) {
                    res.add(curr.val);
                }
                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    queue.offer(curr.left);
                }
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    queue.offer(curr.right);
                }
                if (parents.containsKey(curr) && !visited.contains(parents.get(curr))) {
                    TreeNode parent = parents.get(curr);
                    visited.add(parent);
                    queue.offer(parent);
                }
            }
            level++;
        }
        return res;
    }
    
    public void updateParents(TreeNode node, Map<TreeNode, TreeNode> parents) {
        if (node == null) return;
        
        if (node.left != null) {
            parents.put(node.left, node);
            updateParents(node.left, parents);
        }
        if (node.right != null) {
            parents.put(node.right, node);
            updateParents(node.right, parents);
        }
    }
}
