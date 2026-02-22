import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseOddLevelsOfBinaryTree {

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

    public TreeNode reverseOddLevels(TreeNode root) {

           levelOrder(root);
           return root;
    }

    public static List<List<TreeNode>> levelOrder(TreeNode root) {
        List<List<TreeNode>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int j = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node);

                assert node != null;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            if (j % 2 == 1) reverseNode(level);
            j++;
            result.add(level);
        }

        return result;
    }

    public static void reverseNode(List<TreeNode> list) {

        int i = 0;
        int j = list.size()-1;

        while (i < j) {
            TreeNode first = list.get(i++);
            TreeNode second = list.get(j--);

            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

}
