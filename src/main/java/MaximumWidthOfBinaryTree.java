import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {

    static class TreeNode{
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

    public int widthOfBinaryTree(TreeNode root) {

        List<List<TreeNode>> levels=levelOrder(root);

        int max=Integer.MIN_VALUE;

        for(List<TreeNode> level: levels){
            // System.out.println(level);
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0;i< level.size(); i++){
                if(level.get(i) != null) arr.add(i);
            }

            max = Math.max(arr.getLast() - arr.getFirst()+1, max);
        }

        return max;

    }


    public List<List<TreeNode>> levelOrder(TreeNode root) {

        List<List<TreeNode>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<TreeNode> level = new ArrayList<>();
            boolean allNull = true;

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();
                level.add(node);

                if (node != null) {
                    allNull = false;
                    queue.offer(node.left);
                    queue.offer(node.right);
                }else {
                    queue.offer(null);
                    queue.offer(null);
                }
            }

            if (allNull) break;

            result.add(level);
        }

        return result;
    }
}
