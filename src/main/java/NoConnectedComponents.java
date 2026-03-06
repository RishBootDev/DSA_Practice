import java.util.ArrayList;

public class NoConnectedComponents {

    public int countConnectedComponents(ArrayList<ArrayList<Integer>> graph) {
        boolean vis[] = new boolean[graph.size()];

        int count = 0;
        for (int i = 0; i < vis.length; i++) {
            if(!vis[i]){
                dfs(graph, i, vis);
                count++;
            }
        }
        return count;
    }

    public void dfs(ArrayList<ArrayList<Integer>> graph, int src, boolean vis[]) {

        vis[src] = true;
        for(int x : graph.get(src)) {
            if(!vis[x]) dfs(graph, x, vis);
        }
    }
}
