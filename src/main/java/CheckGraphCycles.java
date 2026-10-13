import java.util.ArrayList;
import java.util.List;

public class CheckGraphCycles {

     public static boolean checkCycles() {
         int n = 4;
         List<List<Integer>> graph = new ArrayList<>();

         for (int i = 0; i <= n; i++) {
             graph.add(new ArrayList<>());
         }
         graph.get(1).add(2);
         graph.get(2).add(1);
         graph.get(1).add(3);
         graph.get(3).add(1);
         graph.get(2).add(3);
         graph.get(3).add(2);

         for (int i = 1; i <= n; i++) {
             System.out.println(i + " -> " + graph.get(i));
         }
         return dfs(graph, 0, 0, new boolean[n]);
     }
     public static boolean dfs(List<List<Integer>> graph, int start, int parent, boolean vis[]) {

         vis[start] = true;

         for(int node : graph.get(start)) {
             if(!vis[node]) {
                 if(dfs(graph, node, start, vis)) return true;
             }else if (node != parent) return true;
         }
         return false;
     }

    public static void main(String[] args) {
        System.out.println(checkCycles());
    }
}
