public class BinaryTreeTilt {

    private int sum;

    public static class TreeNode {
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

    public int findTilt(TreeNode root) {
       helper(root);
       return sum;
    }

    public int helper(TreeNode root) {
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        int temp = Math.abs(left - right);
        sum += temp;
        return temp;
    }
}
