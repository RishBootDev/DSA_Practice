import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SmallestStringStartingFromLeaf {

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

    public String smallestFromLeaf(TreeNode root) {
         List<StringBuilder> ans = new ArrayList<>();
         helper(root, new StringBuilder(), ans);

         for(StringBuilder sb : ans) sb.reverse();

        Collections.sort(ans);
        return ans.getFirst().toString();

    }
    public void helper(TreeNode root, StringBuilder str, List<StringBuilder> list) {

        if (root == null) return;

        StringBuilder sb = new StringBuilder();
        sb.append((char)('a' + root.val));

        if (root.left == null && root.right == null) {
            list.add(sb);
            return;
        }

        helper(root.left, sb, list);
        helper(root.right, sb, list);
        sb.deleteCharAt(sb.length() - 1);
    }
}
