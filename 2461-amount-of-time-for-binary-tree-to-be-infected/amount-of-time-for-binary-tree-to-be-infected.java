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

class Pair{
    int time;
    TreeNode node;
    Pair(TreeNode node, int time){
        this.node =node;
        this.time=time;
    }
}
class Solution {
    static TreeNode start;
    static HashMap<TreeNode, TreeNode> parent;
    public int amountOfTime(TreeNode root, int target) {
        parent= new HashMap<>();
        start=null;
        dfs(root,target);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start,0));
        HashSet<TreeNode> burnt = new HashSet<>();
        burnt.add(start);
        int ans =0;
        while(q.size()>0){
            Pair curr= q.remove();
            TreeNode node = curr.node;
            int time = curr.time;
            ans=Math.max(time,ans);
            if(node.left!=null && !burnt.contains(node.left)) {
                q.add(new Pair(node.left, time+1));
                burnt.add(node.left);
            } 
            if(node.right!=null && !burnt.contains(node.right)){
                q.add(new Pair(node.right, time+1));
                burnt.add(node.right);
            } 
            if(parent.containsKey(node) && !burnt.contains(parent.get(node))) {
                q.add(new Pair(parent.get(node), time+1));
                burnt.add(parent.get(node));
            }
    
        }return ans;
    }
    public static void dfs(TreeNode root, int target){
        if(root==null) return;
        if(root.val==target) start=root;
        if(root.left!=null) parent.put(root.left,root);
        if(root.right!=null) parent.put(root.right,root);

        dfs(root.left,target);
        dfs(root.right,target);
    }
}