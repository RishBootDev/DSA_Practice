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

    public TreeNode lcs(TreeNode root, int p, int q) {

        if(root == null) return null;
        if(root.val == p || root.val == q) return root;
        TreeNode left = lcs(root.left, p, q);
        TreeNode right = lcs(root.right, p, q);
        if(left != null || right != null) return root;
        return null;
    }
}
