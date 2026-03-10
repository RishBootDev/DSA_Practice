import java.util.ArrayList;
import java.util.List;

public class DiagonalTreeTraversal {

    public ArrayList<Integer> diagonal(Node root) {
        // add your code here.

        ArrayList<Integer> ans = new ArrayList<>();
        List<Node> list = new ArrayList<>();

        Node temp = root;
        while(temp != null){
            list.add(temp);
            temp = temp.right;
        }

        while(!list.isEmpty()) {
            List<Node> next = new ArrayList<>();

            for(Node x : list) {
                ans.add(x.data);
            }
            for(Node x : list) {
                if(x.left != null){
                    Node bemp = x.left;
                    while(bemp != null){
                        next.add(bemp);
                        bemp = bemp.right;
                    }
                }
            }

            list = next;
        }

        return ans;
    }


    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
