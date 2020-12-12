# 105. Construct Binary Tree from Preorder and Inorder Traversal
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode dfs(int[] preorder, int i, int j, int[] inorder, int m, int n) {
        if (i > j) {
            return null;
        }
        int k = m;
        while (k <= n) {
            if (inorder[k] == preorder[i]) {
                break;
            }
            k++;
        }
        TreeNode left = dfs(preorder, i + 1, k - m + i, inorder, m, k - 1);
        TreeNode right = dfs(preorder, k - m + i + 1, j, inorder, k + 1, n);
        return new TreeNode(preorder[i], left, right);
    }
}



# 106. Construct Binary Tree from Inorder and Postorder Traversal
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return dfs(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    public TreeNode dfs(int[] inorder, int i, int j, int[] postorder, int m, int n) {
        if (i > j) return null;
        int k = i;
        while (k <= j) {
            if (inorder[k] == postorder[n]) {
                break;
            }
            k++;
        }
        TreeNode left = dfs(inorder, i, k - 1, postorder, m, m + k - i - 1);
        TreeNode right = dfs(inorder, k + 1, j, postorder, m + k - i, n - 1);
        return new TreeNode(postorder[n], left, right);
    }
}


# 889. Construct Binary Tree from Preorder and Postorder Traversal

class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return dfs(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }
    
    public TreeNode dfs(int[] pre, int i, int j, int[] post, int m, int n) {
        if (i > j) {
            return null;
        }
        if (i == j) {
            return new TreeNode(pre[i]);
        }
        int k = m;
        while (k < n) {
            if (post[k] == pre[i + 1]) {
                break;
            }
            k++;
        }
        TreeNode left = dfs(pre, i + 1, i + 1 + k - m, post, m, k);
        TreeNode right = dfs(pre, i + k - m + 2, j, post, k + 1, n - 1);
        return new TreeNode(pre[i], left, right);
    }
}
