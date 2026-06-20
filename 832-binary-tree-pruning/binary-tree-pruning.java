class Solution {
    
    public TreeNode pruneTree(TreeNode root) {

        if (root == null) return null;

        preorder(root);

        if (!helper(root)) {
            return null;
        }

        return root;
    }

    public void preorder(TreeNode root) {
        if (root == null) return;

        preorder(root.left);
        preorder(root.right);

        if (root.left != null && !helper(root.left)) {
            root.left = null;
        }

        if (root.right != null && !helper(root.right)) {
            root.right = null;
        }
    }

    public boolean helper(TreeNode root) {
        if (root == null) return false;

        if (root.val == 1) return true;

        boolean left = helper(root.left);
        boolean right = helper(root.right);

        return left || right;
    }
}