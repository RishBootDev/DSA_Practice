import java.util.ArrayList;
import java.util.List;

public class FlowerPlantingWithNoAdjacent {

    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int path [] : paths) {
            int a  = path[0];
            int b = path[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        List<Integer> ans = new ArrayList<>();
        boolean vis [] = new boolean[n+1];
        dfs(graph, 1, vis, 0, ans );
        System.out.println(ans);
        return new int[n];
    }
    public void dfs(List<List<Integer>> graph, int node, boolean vis[], int j, List<Integer> ans) {

        ans.add(j % 4 + 1);
        vis[node]= true;
        int k = j + 1;
        for(int n : graph.get(node)) {
            if(!vis[n]) {
                dfs(graph, n, vis, k, ans);
                vis[n] = true;
                k++;
            }
        }
    }

}


// 1        2

//     3