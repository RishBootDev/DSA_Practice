import java.util.ArrayList;
import java.util.List;

public class CountNodesEqualToSubtree {

    public int averageOfSubtree(TreeNode root) {

        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        int count = 0;

        for (TreeNode node: list) {

            List<TreeNode> temp = new ArrayList<>();
            inorder(node, temp);

            int  sum = 0;
            for (int i = 0; i < temp.size(); i++) {
                sum += temp.get(i).val;
            }

            if(sum/temp.size() == node.val) count ++;
        }

        return count;

    }

    public void inorder(TreeNode root, List<TreeNode> list) {

        if (root == null) return;

        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }

    static class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}

        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
