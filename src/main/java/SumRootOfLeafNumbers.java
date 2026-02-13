public class SumRootOfLeafNumbers {

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        preOrder(root, 0);
        return sum;
    }

    public void preOrder(TreeNode root, int path) {

        if(root == null) {
           return;
        }
        if (root.left == null && root.right == null) {
            sum +=path;
        }

        preOrder(root.left, path);
        preOrder(root.right, path);

    }


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

}
