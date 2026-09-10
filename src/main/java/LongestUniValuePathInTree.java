public class LongestUniValuePathInTree {

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

    public int longestUnivaluePath(TreeNode root) {

        inorder(root);
        return max;
    }
    private Integer max = Integer.MIN_VALUE;
    public void inorder(TreeNode root) {
        if(root == null) return;

        inorder(root.left);
        max = Math.max(max, dist(root));
        inorder(root.right);
    }
    public int dist(TreeNode root) {
        if(root == null) return 0;
        int left = 0;
        int right = 0;
        if(root.val == root.left.val) left = dist(root.left) + 1;
        if(root.val == root.right.val) right = dist(root.right) + 1;
        return left + right + 1;
    }
}
