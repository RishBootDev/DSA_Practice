import java.util.ArrayList;
import java.util.List;

public class FlipBinaryTreeToMatchPreOrderTraversal {

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

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {

        return helper(root, voyage, 0);
    }
    public List<Integer> helper(TreeNode root, int[] voyage, int i) {
        if(root.val != voyage[i]) {
            List<Integer> ans = new ArrayList<>();
            ans.add(-1);
            return ans;
        }
        List<Integer> ans = new ArrayList<>();
        int left = voyage[2 * i - 1];
        int right = voyage[2 * i + 1];
        if(root.left.val == left && root.right.val == right) {
            helper(root.left, voyage, 2 * i - 1);
            helper(root.right, voyage, 2 * i + 1);
        }

        else if (root.left.val == right && root.right.val == left) {
            ans.add(root.val);
            helper(root.right, voyage, 2 * i - 1);
            helper(root.left, voyage, 2 * i + 1);
        }else {
            List<Integer> temp = new ArrayList<>();
            temp.add(-1);
            return temp;
        }
        return ans;
    }
}
