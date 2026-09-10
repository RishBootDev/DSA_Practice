import java.util.ArrayList;
import java.util.List;

public class BstToGst {

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

    public TreeNode bstToGst(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int sum = 0;
        for (int i = list.size() - 1; i >= 0 ; i--) {
            sum += list.get(i);
            list.set(sum, i);
        }
        process(root, list, 0);
        return root;
    }
    public void process(TreeNode root, List<Integer> list, int i) {
        if(root == null) return;

        process(root.left, list, i + 1);
        root.val = list.get(i);
        process(root.right, list, i + 1);
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if(root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
