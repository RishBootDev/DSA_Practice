import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphsBfsCode {

    public static void bfs(ArrayList<ArrayList<Integer>> graph, int src, boolean[] vis) {

        Queue<Integer> queue = new LinkedList<>();
        vis[src] = true;
        queue.add(src);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.println(curr);
            for (int x : graph.get(curr)) {
                if (!vis[x]) {
                    queue.add(x);
                    vis[x] = true;
                }
            }
        }
    }


    // this the code responsible for calculating the distance between the source and other nodes distances
    public static void bfsWithDistance(ArrayList<ArrayList<Integer>> graph, int src, boolean vis[], int[] dist) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        vis[src] = true;
        dist[src] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int x : graph.get(curr)) {
                if (!vis[x]) {
                    queue.add(x);
                    vis[x] = true;
                    dist[x] = dist[curr] + 1;
                }
            }
        }
    }
}
