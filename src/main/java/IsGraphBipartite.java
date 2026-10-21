public class IsGraphBipartite {

    // this is correct approach using the coloring intuition
    int color[];
    public boolean isBipartite(int[][] graph) {
       this.color = new int[graph.length];
       boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                color[i] = 1;
                if (!twoColor(graph, i, vis)) return false;
            }
        }
       return true;
    }

    public boolean twoColor(int [][] graph, int start, boolean vis[]) {
        vis[start] = true;
        boolean ans = true;
        for(int node : graph[start]) {
            if(vis[node]) {
                if(color[node] == color[start]) return false;
            }else {
                vis[node] = true;
                if(color[start] == 1) {
                    color[node] = 2;
                }else color[node] = 1;
                ans &= twoColor(graph, node, vis);
            }
        }
        return ans;
    }
}
