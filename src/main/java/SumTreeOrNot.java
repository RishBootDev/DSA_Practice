public class SumTreeOrNot {

    static class Node {
            int data;
            Node left, right;

            Node(int item)
            {
                data = item;
                left = right = null;
            }

    }

    boolean isSumTree(Node root) {
        // Your code here

        if(root==null) return true;

        if (root.left == null && root.right == null) return true;

        int a=sum(root.left);
        int b=sum(root.right);

        if(root.data!=b+a) return false;


        if (root.data != a + b) return false;

        return isSumTree(root.left) && isSumTree(root.right);
    }

    public int sum(Node root){

        if (root == null) return 0;

        return root.data + sum(root.left) + sum(root.right);
    }
}
