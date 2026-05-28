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

    private Map<String, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null) return 0;

        if(map.containsKey(root.toString())) return map.get(root.toString()); 

        // take
        int first = root.left == null? 0 : rob(root.left.left);
        int second = root.left == null ? 0: rob(root.left.right);
        int third = root.right == null ? 0: rob(root.right.left);
        int fourth = root.right == null ? 0: rob(root.right.right);
        
        
        int take = root.val+first + second + third + fourth;

        // not take
        int not = rob(root.left) + rob(root.right);

        int ans = Math.max(take, not);
        map.put(root.toString(), ans);

        return ans;
    }
}