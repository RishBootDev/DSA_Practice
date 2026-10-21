import java.util.ArrayList;
import java.util.List;

public class PossibleBipartition {

    int color[];
    public boolean possibleBipartition(int n, int[][] dislikes) {
        this.color = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int [] dislike : dislikes) {
            int a = dislike[0];
            int b = dislike[1];
            graph.get(a - 1).add(b - 1);
            graph.get(b - 1).add(a - 1);
        }
        boolean vis[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!vis[i]) {
                color[i] = 1;
                if(!helper(graph, i, vis)) return false;
            }
        }
        return true;
    }
    public boolean helper(List<List<Integer>> graph, int start, boolean vis[]) {
        vis[start] = true;

        boolean ans = true;
        for(int node : graph.get(start)) {
            if(vis[node]) {
                if(color[start] == color[node]) return false;
            }else {
                color[node] = color[start] == 1?2 : 1;
                ans &= helper(graph, node, vis);
            }
        }
        return ans;
    }
}
