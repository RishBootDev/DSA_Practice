import java.util.HashMap;
import java.util.Map;

public class LongestZigZagPath {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    Map<String, Integer> map = new HashMap<>();
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;

        if(map.containsKey(root.toString())){
            return map.get(root.toString());
        }
        int left = helper(root.left, "left");
        int right = helper(root.right, "right");

        int startLeft = longestZigZag(root.left);
        int startRight = longestZigZag(root.right);
        int ans = Math.max(Math.max(left, right), Math.max(startLeft, startRight));
        map.put(root.toString(), ans);
        return ans;
    }

    public int helper(TreeNode root, String dir) {
        if (root == null) return 0;

        if (dir.equals("left")) {
            return 1 + helper(root.right, "right");
        } else {
            return 1 + helper(root.left, "left");
        }
    }
}
