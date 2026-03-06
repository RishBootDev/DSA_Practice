import java.util.ArrayList;

public class DFSGraphBhai {

    public static void dfs(ArrayList<ArrayList<Integer>> graph, int src, boolean vis[]) {
        
        vis [src] = true;

        for(int x : graph.get(src)) {
            if(!vis[x]) {
                dfs(graph, x, vis);
            }
        }
    }
}
