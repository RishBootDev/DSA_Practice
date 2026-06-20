import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

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

  List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
           ans = new ArrayList<>();
           helper(root, 0, new ArrayList<>(), targetSum);
           return ans;
    }
    public void helper(TreeNode root, int sum, List<Integer> list, int target) {
        if(root == null) return;

        sum += root.val;
        if(sum == target && root.left == null && root.right == null) {
            list.add(root.val);
            ans.add(new ArrayList<>(list));
        }

        helper(root.left, sum, list, target);
        helper(root.right, sum, list, target);
        list.removeLast();
    }
}
