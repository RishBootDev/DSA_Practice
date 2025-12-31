public class MergeBinaryTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
          return merge(root1, root2);
    }

    public TreeNode merge(TreeNode t1, TreeNode t2) {

        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;

        t1.val += t2.val;
        t1.left = merge(t1.left, t2.left);
        t1.right = merge(t1.right, t2.right);

        return t1;
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.val = data;
            this.left = null;
            this.right = null;
        }
    }
}
