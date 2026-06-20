import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NodesKDistanceInABinaryTree {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<List<Integer>> graph = new ArrayList<>();
        inorder(root, graph);

        return bfs(graph, target.val, k);

    }

    public List<Integer> bfs(List<List<Integer>> graph, int start, int k) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean vis[] = new boolean[graph.size()];

        queue.offer(start);
        while(!queue.isEmpty() && k--> 0) {
            int node = queue.poll();
            ans.add(node);

            for(int n : graph.get(node)) {
                if(!vis[n]) {
                    queue.offer(n);
                    vis[n] = true;
                }
            }
        }
        return ans;
    }

    public void inorder(TreeNode root, List<List<Integer>> graph) {
        if(root == null) return;

        inorder(root.left, graph);
        graph.add(new ArrayList<>());

        if(root.left != null) {
            graph.get(root.val).add(root.left.val);
            graph.get(root.left.val).add(root.val);
        }
        if(root.right != null) {
            graph.get(root.val).add(root.right.val);
            graph.get(root.right.val).add(root.val);
        }
        inorder(root.right, graph);
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
