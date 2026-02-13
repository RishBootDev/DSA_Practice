import java.util.ArrayList;
import java.util.List;

public class TrimBinaryTree {

    public static void main(String[] args) {

    }

    public TreeNode trimBST(TreeNode root, int low, int high) {

        List<Integer>  list = new ArrayList<>();
        inorder(root,list, low, high);

        TreeNode temp = null;

        for (int val : list) {
            temp = insert(root, val);
        }

        return root;


    }

    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public void inorder(TreeNode root, List<Integer> list,int low, int high) {

        if (root == null) return ;

        inorder(root.left,list,low, high);
        if(root.val >= low && root.val <= high) list.add(root.val);
        inorder(root.right, list, low, high);
    }


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
}
