import java.util.ArrayList;
import java.util.List;

public class InvokeMethods {

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int []in : invocations) {
            graph.get(in[0]).add(in[1]);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean vis[] = new boolean[n];
            if(dfs(graph, vis, i, k)) {
                ans.add(i);
            }
        }
        return ans;

    }
    public boolean dfs(List<List<Integer>> graph,boolean vis[], int start, int k) {

        if(start == k) return false;

        boolean temp = true;
        vis[start] = true;
        for(int node : graph.get(start)) {
            if(!vis[node]) {
                temp &= dfs(graph, vis, node, k);
            }
        }
        return temp;
    }

}
