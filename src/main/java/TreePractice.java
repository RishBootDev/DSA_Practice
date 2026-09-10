public class TreePractice {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode addLeft(TreeNode root, int data) {
        TreeNode newNode = new TreeNode(data);
        root = new TreeNode(100);
        root.left = newNode;
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root = addLeft(root, 20);
        System.out.println(root.val);
        System.out.println(root.left.val);
    }
}
