public class MaxProduct_Of_SplittedBinaryTree {

    private long max = 0;
    private static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {

        int totalSum = helper(root);
        inorder(root, totalSum);

        return (int)(max % MOD);
    }

    public void inorder(TreeNode root, int totalSum) {

        if (root == null) return;

        inorder(root.left, totalSum);

        int subTreeSum = helper(root);
        long product = (long) subTreeSum * (totalSum - subTreeSum);
        max = Math.max(max, product);

        inorder(root.right, totalSum);
    }

    public int helper(TreeNode root) {

        if (root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        return root.val + left + right;
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
