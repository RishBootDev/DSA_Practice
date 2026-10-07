/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode ans=null;
    public TreeNode increasingBST(TreeNode root) {
        
        List<Integer> arr=new ArrayList<>();
        inorder(root,arr);

        TreeNode root2=new TreeNode(arr.get(0));
        TreeNode temp=root2;

        for(int i=1;i<arr.size();i++){
            TreeNode newNode=new TreeNode(arr.get(i));
            temp.right=newNode;
            temp=temp.right;
        }

        return root2;
    }

    public void inorder(TreeNode root,List<Integer> arr){
        if(root==null)  return ;


        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
}