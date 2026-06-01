public class PruneTree {

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

    public TreeNode pruneTree(TreeNode root) {

        preorder(root);
        return root;
    }

    public void preorder(TreeNode root) {
        if(root == null) return ;

        preorder(root.left);
        preorder(root.right);
        if (!helper(root)) {
            root = null;
        }
    }
    public boolean helper(TreeNode root) {
        if(root == null) return false;
        if(root.val == 1) return true;

        boolean left = helper(root.left);
        boolean right = helper(root.right);

        return left || right;
    }
}
