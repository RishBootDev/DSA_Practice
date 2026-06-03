public class PathSum3 {

    static class TreeNode {
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

   int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        inorder(root, targetSum);
        return count;
    }

    public void inorder(TreeNode root, int target) {
        if(root == null) return;

        inorder(root.left, target);
        if(root.val <= target) {
            countPath(root, target);
        }
        inorder(root.right, target);
    }
    public void countPath(TreeNode root, int target) {
        if(root == null) return;
        if(target < 0) return;
        if(target == 0) {
            count++;
            return;
        }

        countPath(root.left, target - root.val);
        countPath(root.right, target - root.val);
    }
}
