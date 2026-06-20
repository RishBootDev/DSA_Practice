import java.util.ArrayList;
import java.util.List;

public class ValidateBinaryTreeValues {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        List<List<Integer>> graph = new ArrayList<>();
        build(leftChild, rightChild, graph);
        return !hasCycle(n, graph);
    }
    public boolean hasCycle(int V, List<List<Integer>> graph) {
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i] && dfs(i, -1, vis, graph)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, int parent,
                        boolean[] vis,
                        List<List<Integer>> graph) {

        vis[node] = true;

        for (int nei : graph.get(node)) {
            if (!vis[nei]) {
                if (dfs(nei, node, vis, graph))
                    return true;
            }
            else if (nei != parent) {
                return true;
            }
        }
        return false;
    }


    public void build(int left[], int right[], List<List<Integer>> graph) {

        for(int c : left) graph.add(new ArrayList<>());

        for (int i = 0; i < left.length; i++) {
            if(left[i] != -1) {
                graph.get(i).add(left[i]);
                graph.get(left[i]).add(i);
            }
            if(right[i] != -1) {
                graph.get(i).add(right[i]);
                graph.get(right[i]).add(i);
            }
        }
    }
}
