import java.util.ArrayList;
import java.util.List;

public class PrintNodesHavingKLeaves {

    public ArrayList<Integer> btWithKleaves(Node root, int k) {

        List<Node> list = new ArrayList<>();
        inorder(root, list);
        ArrayList<Integer> ans = new ArrayList<>();

        for(Node x : list) {
           int count = countLeaves(x);
           if(count == k) ans.add(x.data);
        }

        return ans;
    }

    public void inorder(Node root, List<Node> list) {

        if(root == null) return;

        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }

    public int countLeaves(Node root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;

        int left = countLeaves(root.left);
        int right = countLeaves(root.right);

        return left + right +1;
    }

    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }
}
