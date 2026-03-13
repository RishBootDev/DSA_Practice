public class IsBinaryTreeFoldable {

    static class Node
    {
        int data;
        Node left, right;
        Node(int key)
        {
            data = key;
            left = right = null;
        }
    }

    boolean IsFoldable(Node node) {
        // your code

        if(node == null) return true;

        return check (node.left, node.right);
    }

    boolean check(Node a , Node b) {

        if(a == null && b == null) return true;

        if(a == null || b == null) return false;

        return check(a.left, b.right) && check (a.right, b.left);
    }
}
