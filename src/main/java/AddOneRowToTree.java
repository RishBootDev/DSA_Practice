public class AddOneRowToTree {

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

    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        helper(root, 0, depth, val);
        return root;
    }

    public void helper(TreeNode root, int x, int depth, int val) {

        if (root == null) return;

        if (x == depth - 2) {

            TreeNode left = root.left;
            TreeNode right = root.right;

            TreeNode newNode1 = new TreeNode(val);
            TreeNode newNode2 = new TreeNode(val);

            root.left = newNode1;
            root.right = newNode2;

            newNode1.left = left;
            newNode2.right = right;

            return;
        }

        helper(root.left, x + 1, depth, val);
        helper(root.right, x + 1, depth, val);
    }
}