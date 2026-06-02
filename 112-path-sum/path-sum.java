class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        return helper(root, targetSum, root.val);
    }

    public boolean helper(TreeNode root, int target, int curr) {

        if(root == null) return false;

        if(root.left == null && root.right == null) {
            return curr == target;
        }

        boolean left = false;
        boolean right = false;

        if(root.left != null) {
            left = helper(root.left, target, curr + root.left.val);
        }

        if(root.right != null) {
            right = helper(root.right, target, curr + root.right.val);
        }

        return left || right;
    }
}