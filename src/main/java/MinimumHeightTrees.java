import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
           graph.add(new ArrayList<>());
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            boolean vis[] = new boolean[n];
            min = Math.min(min, getHeight(graph, i, vis));
        }

        for (int i = 0; i < n; i++) {
            boolean vis[] = new boolean[n];
            int temp = getHeight(graph, i, vis);
            if(temp == min) ans.add(i);
        }
        return ans;
    }

    public int getHeight(List<List<Integer>> graph, int start, boolean vis[]) {
        vis[start] = true;
        if(graph.get(start).isEmpty()) return 1;

        int max = 0;

        for(int node : graph.get(start)) {
            if(!vis[node]) {
                int temp = getHeight(graph, node, vis) + 1;
                max = Math.max(max, temp);
                vis[node] = true;
            }
        }
        return max;
    }
}
