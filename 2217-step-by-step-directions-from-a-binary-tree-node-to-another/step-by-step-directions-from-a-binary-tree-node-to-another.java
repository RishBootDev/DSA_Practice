/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<String> paths;

    public String getDirections(TreeNode root, int start, int dest) {
        this.paths = new ArrayList<>();
        TreeNode lca = lca(root, start, dest);
        visit(lca, start, new StringBuilder());
        visit(lca, dest, new StringBuilder());
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < paths.getFirst().length(); i++) {
            temp.append('U');
        }
        if (lca.val == start) {
            return paths.getLast();
        } else if (lca.val == dest)
            return temp.toString();

        System.out.println(lca.val);
        return temp + paths.getLast();
    }

    public TreeNode lca(TreeNode root, int p, int q) {
        if (root == null)
            return null;

        if (root.val == p || root.val == q)
            return root;

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if (left != null && right != null)
            return root;
        if (left != null)
            return left;
        return right;
    }

    public void visit(TreeNode root, int dest, StringBuilder sb) {
        if (root == null)
            return;
        if (root.val == dest) {
            System.out.println(sb);
            paths.add(sb.toString());
            return;
        }

        sb.append('L');
        visit(root.left, dest, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append('R');
        visit(root.right, dest, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}