public class LCALowestCommonAncestor {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public TreeNode lca(TreeNode root, int p, int q) {
        if(root == null) return null;

        if(root.val == p || root.val == q) return root;

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if(left != null && right != null) return root;

        if(left != null) return left;
        return right;
    }

}
