import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSorting {

    public static void topo(ArrayList<ArrayList<Integer>> graph) {

        boolean vis[] = new boolean[graph.size()];
        Stack<Integer> stack = new Stack<>();
        dfs(graph, 0, vis, stack);

        while (stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void dfs(ArrayList<ArrayList<Integer>> graph, int src, boolean vis[], Stack<Integer> stack) {

        vis[src] = true;

        for (Integer x : graph.get(src)) {
            if (!vis[x]) {
                vis[x] = true;
                dfs(graph, x, vis, stack);
            }
        }
        stack.push(src);
    }

    // now this is the kahn algorithm which is based on the feature of bfs .\\

    static void topologicalOrderingKahnAlgo(ArrayList<ArrayList<Integer>> graph, int V) {
        Queue<Integer> q = new LinkedList<>();
        int inDegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int e : graph.get(i)) {
                inDegree[e]++;
            }
        }
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.println(cur);

            for (int neighbor : graph.get(cur)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
    }
}
