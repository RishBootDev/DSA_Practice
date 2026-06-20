import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReachableNodesWithRestrictions {

    public int reachableNodes(int n, int[][] edges, int[] restricted) {

        List<List<Integer>> graph = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int c : restricted) set.add(c);

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int [] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
        }
        boolean vis[] = new boolean[n];
        return dfs(graph, 0, set, vis );
    }
    public int dfs(List<List<Integer>> graph,int node, Set<Integer> res, boolean [] vis) {

        if(res.contains(node)) return 0;

        vis[node] = true;
        int count = 1;
        for(int n : graph.get(node)) {
            if(!vis[n]) {
                count += dfs(graph, n, res,vis);
            }
        }
        return count;
    }
}
