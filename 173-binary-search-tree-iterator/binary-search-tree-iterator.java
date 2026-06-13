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
class BSTIterator {
    List<TreeNode> list;
    int i = -1;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
    }
    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
    
    public int next() {
       return list.get(i++ + 1).val;
    }
    
    public boolean hasNext() {
        if(i + 1 < list.size()) return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */