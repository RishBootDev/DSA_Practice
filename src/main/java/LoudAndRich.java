import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LoudAndRich {

    public int[] loudAndRich(int[][] richer, int[] quiet) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < quiet.length; i++) {
           graph.add(new ArrayList<>());
        }
        for (int i = 0; i < richer.length; i++) {
            int rich = richer[i][0];
            int poor = richer[i][1];
            graph.get(poor).add(rich);
        }
        int res [] = new int[quiet.length];
        System.out.println(graph);
        for (int i = 0; i < quiet.length; i++) {
             boolean vis[] = new boolean[quiet.length];
             PriorityQueue<Integer> pq = new PriorityQueue<>(
                     Comparator.comparingInt(p -> quiet[p])
             );
             dfs(graph, i, vis, pq);
             res[i] = pq.isEmpty()?0:pq.poll();
        }
        return res;
    }
    public void dfs(List<List<Integer>> graph, int start, boolean vis[], PriorityQueue<Integer> pq) {

        vis[start] = true;
        pq.add(start);

        for (int node : graph.get(start)) {
            if(!vis[node]) {
                dfs(graph, node, vis, pq);
            }
        }
    }
}
