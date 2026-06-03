import java.util.ArrayList;
import java.util.List;

public class DistributeCoinsInABinaryTree {

    private int ans;

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public int distributeCoins(TreeNode root) {
         List<List<Integer>> graph = new ArrayList<>();
         inorder(graph, root);
         buildGraph(graph, root, 0);
         System.out.println(graph);
         helper(graph, root, 0);
         return this.ans;
    }
    public void buildGraph(List<List<Integer>> graph, TreeNode root, int num) {
        if(root == null) return;
        if(root.left != null) {
            graph.get(num).add(num + 1);
            graph.get(num + 1).add(num);
        }
        if(root.right != null) {
            graph.get(num).add(num + 2);
            graph.get(num + 2).add(num);
        }
        buildGraph(graph, root.left, num +1);
        buildGraph(graph, root.right , num + 2);
    }
    public void inorder(List<List<Integer>> graph, TreeNode root) {
        if(root == null) return;

        inorder(graph, root.left);
        graph.add(new ArrayList<>());
        inorder(graph, root.right);
    }

    public void helper(List<List<Integer>> graph, TreeNode root, int num) {
        if(root == null) return;
        if(root.val != 0) {
            dfs(graph, num, new boolean[graph.size()], 1);
            return;
        }
        helper(graph, root.left, num + 1);
        helper(graph, root.right, num + 2);
    }

    public void dfs(List<List<Integer>> graph, int start, boolean vis[], int dist) {
        vis[start] = true;

        for(int node : graph.get(start)) {
            if(!vis[node]) {
                dfs(graph, node, vis, dist + 1);
                vis[node] = true;
                ans += dist;
            }
        }
    }
}
