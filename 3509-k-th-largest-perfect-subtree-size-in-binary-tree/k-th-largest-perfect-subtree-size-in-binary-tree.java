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
    
    PriorityQueue<Integer> pq;

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        pq = new PriorityQueue<>(Collections.reverseOrder());

        inorder(root);

        if (pq.size() < k) return -1;

        int ans = -1;
        while (k-- > 0) {
            ans = pq.poll();
        }
        return ans;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (isPerfect(root)) {
            pq.add(size(root));
        }

        inorder(root.right);
    }

    public int size(TreeNode root) {
        if (root == null) return 0;

        return size(root.left) + size(root.right) + 1;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public boolean isPerfect(TreeNode root) {
        if (root == null) return true;

        if (root.left == null && root.right == null)
            return true;

        if (root.left == null || root.right == null)
            return false;

        return isPerfect(root.left) && isPerfect(root.right) && height(root.left) == height(root.right);
    }
}