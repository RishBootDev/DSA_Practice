import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateSubTrees {

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

    private Set<String> set;
    private List<TreeNode> ans;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        set = new HashSet<>();
        check(root);
        return ans;
    }
    public void check(TreeNode root) {
        if(root == null) return;
        if(set.contains(path(root))) {
            ans.add(root);
        }else {
            add(root);
        }
        check(root.left);
        check(root.right);
    }

    public void add(TreeNode root) {
        List<Integer> temp = new ArrayList<>();
        preorder(root, temp);
        set.add(temp.toString());
    }
    public String path(TreeNode root) {
        List<Integer> temp = new ArrayList<>();
        preorder(root, temp);
        return temp.toString();
    }
    public void preorder(TreeNode root, List<Integer> temp) {
        if(root ==  null) return;
        temp.add(root.val);
        preorder(root.left, temp);
        preorder(root.right, temp);
    }
}
