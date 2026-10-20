import java.util.*;

public class PrimsAlgorithm {

    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static class Pair {
        int node;
        int wt;

        Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {

        int V = 7;

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // 0 - 1
        graph.get(0).add(new Edge(0, 1, 4));
        graph.get(1).add(new Edge(1, 0, 4));

        // 0 - 2
        graph.get(0).add(new Edge(0, 2, 3));
        graph.get(2).add(new Edge(2, 0, 3));

        // 0 - 3
        graph.get(0).add(new Edge(0, 3, 7));
        graph.get(3).add(new Edge(3, 0, 7));

        // 1 - 2
        graph.get(1).add(new Edge(1, 2, 2));
        graph.get(2).add(new Edge(2, 1, 2));

        // 1 - 4
        graph.get(1).add(new Edge(1, 4, 5));
        graph.get(4).add(new Edge(4, 1, 5));

        // 2 - 3
        graph.get(2).add(new Edge(2, 3, 6));
        graph.get(3).add(new Edge(3, 2, 6));

        // 2 - 4
        graph.get(2).add(new Edge(2, 4, 8));
        graph.get(4).add(new Edge(4, 2, 8));

        // 2 - 5
        graph.get(2).add(new Edge(2, 5, 9));
        graph.get(5).add(new Edge(5, 2, 9));

        // 3 - 5
        graph.get(3).add(new Edge(3, 5, 1));
        graph.get(5).add(new Edge(5, 3, 1));

        // 3 - 6
        graph.get(3).add(new Edge(3, 6, 10));
        graph.get(6).add(new Edge(6, 3, 10));

        // 4 - 5
        graph.get(4).add(new Edge(4, 5, 4));
        graph.get(5).add(new Edge(5, 4, 4));

        // 4 - 6
        graph.get(4).add(new Edge(4, 6, 6));
        graph.get(6).add(new Edge(6, 4, 6));

        // 5 - 6
        graph.get(5).add(new Edge(5, 6, 2));
        graph.get(6).add(new Edge(6, 5, 2));

        System.out.println(primsAlgo(graph));
    }


    public static int primsAlgo(List<List<Edge>> graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(
                (e1, e2) -> e1.wt - e2.wt
        );

        pq.add(new Edge(-1, 0, 0));
        boolean vis[] = new boolean[graph.size()];

        int ans = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (vis[edge.dest]) continue;

            vis[edge.dest] = true;
            ans += edge.wt;

            for (Edge e : graph.get(edge.dest)) {
                if (!vis[e.dest]) {
                    pq.add(new Edge(edge.dest, e.dest, e.wt));
                }
            }
        }
        return ans;
    }

}