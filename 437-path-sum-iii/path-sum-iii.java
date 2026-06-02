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

    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        inorder(root, targetSum);
        return count;
    }

    public void inorder(TreeNode root, int target) {
        if (root == null)
            return;

        inorder(root.left, target);
        countPath(root, target);
        inorder(root.right, target);
    }

    public void countPath(TreeNode root, long target) {

        if (root == null)
            return;

        target -= root.val;

        if (target == 0) {
            count++;
        }

        countPath(root.left, target);
        countPath(root.right, target);
    }
}