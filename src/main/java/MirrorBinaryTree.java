
public class MirrorBinaryTree {

    void mirror(Node root) {

        if(root==null) return;

        Node temp=root.left;
        root.left=root.right;
        root.right=temp;


        mirror(root.left);
        mirror(root.right);

    }
    static class Node{
        int data;
        Node left,right;

        public Node(int item){
            this.data=item;
            left=right=null;
        }
    }
}
