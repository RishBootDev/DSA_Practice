class Solution {
   
    private int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        inorder(root);
        return max;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        
        inorder(root.left);
        dist(root);
        inorder(root.right);
    }

    public int dist(TreeNode root) {
        if (root == null) return 0;

        int left = 0;
        int right = 0;

        if (root.left != null && root.val == root.left.val) {
            left = dist(root.left) + 1;
        }

        if (root.right != null && root.val == root.right.val) {
            right = dist(root.right) + 1;
        }

        max = Math.max(max, left + right);

        return Math.max(left, right);
    }
}