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
    int max;
    public int maxAncestorDiff(TreeNode root) {
        
        preorder(root);

        return max;
    }
    public void preorder(TreeNode root) {
        if(root == null) return ;
        inorder(root, root.val);
        preorder(root.left);
        preorder(root.right);
    }
    public void inorder(TreeNode root, int a){
        if(root == null) return;

        inorder(root.left, a);
        max = Math.max(max, Math.abs(root.val - a));
        inorder(root.right, a);
    }
}