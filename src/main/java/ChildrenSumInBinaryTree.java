public class ChildrenSumInBinaryTree {


    static class Node{
        int data;
        Node left,right;

        Node(int key)
        {
            data = key;
            left = right = null;
        }
    }

    public boolean isSumProperty(Node root) {

        if (root == null) return true;
        if (root.left == null && root.right == null) return true;

        int left = 0;
        int right = 0;
        if (root.left != null)
            left = root.left.data;

        if (root.right != null)
            right = root.right.data;

        if (left + right != root.data)
            return false;

        return isSumProperty(root.left) &&
                isSumProperty(root.right);
    }
}
