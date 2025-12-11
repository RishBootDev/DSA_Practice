import java.util.ArrayList;

public class BoundaryTraversalClass {

    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> ans=new ArrayList<>();


        if(root==null) return ans;
        if(root.left==null && root.right==null) {
            ans.add(root.data);
            return ans;
        }

        ans.add(root.data);

        getLeftElements(ans,root.left);
        getLeafElements(ans,root);
        ArrayList<Integer> rightList=new ArrayList<>();
        getRightElements(rightList,root.right);

        for(int i=rightList.size()-1;i>=0;i--)
            ans.add(rightList.get(i));

        return ans;
    }

    public void getLeftElements(ArrayList<Integer> left,Node root){
        Node temp=root;
        while(temp!=null){
            if(temp.left==null && temp.right==null) break;
            left.add(temp.data);
            if(temp.left!=null) temp=temp.left;
            else temp=temp.right;
        }
    }

    public void getRightElements(ArrayList<Integer> right,Node root){
        Node temp=root;
        while(temp!=null){
            if(temp.left==null && temp.right==null) break;
            right.add(temp.data);
            if(temp.right!=null) temp=temp.right;
            else temp=temp.left;
        }
    }

    public void getLeafElements(ArrayList<Integer> arr,Node root){
        if(root==null) return;
        getLeafElements(arr,root.left);
        if(root.left==null && root.right==null)
            arr.add(root.data);
        getLeafElements(arr,root.right);
    }


    static class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }
}
