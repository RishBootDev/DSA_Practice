import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTreeInserter {

    public static class TreeNode {
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

        private TreeNode root;

        public CompleteBinaryTreeInserter(TreeNode root) {
              this.root = root;
        }

        public int insert(int val) {

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(this.root);

            while(!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();
                    if(curr.left == null) {
                        TreeNode newNode = new TreeNode(val);
                        curr.left = newNode;
                        return curr.val;
                    }else if(curr.right == null) {
                        TreeNode newNode = new TreeNode(val);
                        curr.right = newNode;
                        return curr.val;
                    }else {
                        queue.offer(curr.left);
                        queue.offer(curr.right);
                    }
                }
            }

            return -1;
        }

        public TreeNode get_root() {
            return this.root;
        }
}
