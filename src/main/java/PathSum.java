public class PathSum {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum, root.val);

    }
    public boolean helper(TreeNode root, int target, int curr) {
        if(root == null) return false;
        if(root.left == null && root.right == null) {
            if(curr == target) return true;
            else return false;
        }

        boolean left = helper(root.left, target, curr + root.val);
        boolean right = helper(root.right, target, curr + root.val);
        return left || right;
    }
}
