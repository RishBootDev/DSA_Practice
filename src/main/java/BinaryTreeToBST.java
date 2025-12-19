import java.util.ArrayList;
import java.util.Collections;

public class BinaryTreeToBST {

    Node binaryTreeToBST(Node root) {
        ArrayList<Integer> arr=new ArrayList<>();
        inorder(root,arr);
        Collections.sort(arr);

        return changeBST(arr,0,arr.size()-1);

    }
    public void inorder(Node root,ArrayList<Integer> arr){
        if(root==null)  return;

        inorder(root.left,arr);
        arr.add(root.data);
        inorder(root.right,arr);
    }

    public  Node changeBST(ArrayList<Integer> arr, int s, int l){
        if(s>l)  return null;

        int mid=(s+l)/2;
        Node root = new Node(arr.get(mid));

        root.left = changeBST(arr, s, mid - 1);
        root.right = changeBST(arr, mid + 1, l);

        return root;
    }

    static class Node{
        int data;
        Node left, right;
        Node(int item){
            data = item;
            left = right = null;
        }
    }
}
