import java.util.ArrayList;
import java.util.List;

public class SumOfDistancesInATree {

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
       List<List<Integer>> graph = buildGraph(n, edges);

       int ans [] = new int[n];
        for (int i = 0; i < n; i++) {
            int dist = 0;
            for (int j = 0; j < n; j++) {
                dist += distance(n,graph, i, j);
            }
            ans[i] = dist;
        }
        return ans;
    }

    public int distance(int n, List<List<Integer>> graph, int src, int dest) {
        boolean[] vis = new boolean[n];
        return dfs(graph, src, dest, vis);
    }

    private int dfs(List<List<Integer>> graph, int curr, int dest, boolean[] vis) {
        if (curr == dest) return 0;

        vis[curr] = true;

        for (int nei : graph.get(curr)) {
            if (!vis[nei]) {
                int dist = dfs(graph, nei, dest, vis);

                if (dist != -1) {
                    return dist + 1;
                }
            }
        }
        return -1;
    }

    public List<List<Integer>> buildGraph(int n, int edges[][]) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int [] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
        }
        return graph;
    }
}
