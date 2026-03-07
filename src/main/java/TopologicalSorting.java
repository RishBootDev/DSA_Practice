import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting {

    public static void topo(ArrayList<ArrayList<Integer>> graph) {

        boolean vis[] = new boolean[graph.size()];
        Stack<Integer> stack = new Stack<>();
        dfs(graph, 0, vis, stack);

        while(stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void dfs(ArrayList<ArrayList<Integer>> graph,int src, boolean vis[], Stack<Integer> stack) {

        vis[src] = true;

        for(Integer x : graph.get(src)) {
            if(!vis[x]) {
                vis[x] = true;
                dfs(graph, x, vis, stack);
            }
        }
        stack.push(src);
    }
}
