public class DeepestLeavesSum {

    int maxDepth;
    int sum;

    public int deepestLeavesSum(TreeNode root) {

        setMaxDepth(root, 1);
        inorder(root, 1);
        return sum;
    }

    public void inorder(TreeNode root, int i ){

        if (root == null) return;

        inorder(root.left, i+1);
        if(i == maxDepth) sum += root.val;
        inorder(root.right, i+1);

    }

    public void setMaxDepth(TreeNode root, int i) {
        if (root == null) return;

        setMaxDepth(root.left, i+1);
        maxDepth = Math.max(maxDepth, i);
        setMaxDepth(root.right, i + 1);
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
