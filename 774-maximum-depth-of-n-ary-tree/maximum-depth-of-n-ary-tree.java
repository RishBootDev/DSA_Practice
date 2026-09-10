/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int max = Integer.MIN_VALUE;
    public int maxDepth(Node root) {
        if(root == null) return 0;
        helper(root, 1);
        return max;
    }
    public void helper(Node root, int depth) {
        if(root.children.isEmpty()) {
            System.out.println(depth);
            max = Math.max(depth, max);
            return;
        }
        
        for(Node child : root.children) {
            helper(child, depth + 1);
        }
    }
}