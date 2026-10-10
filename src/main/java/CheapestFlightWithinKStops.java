import java.util.ArrayList;
import java.util.List;

public class CheapestFlightWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            Pair pair = new Pair(flight[1], flight[2]);
            graph.get(flight[0]).add(pair);
        }
        int ans = dfs(graph, src, dst, k, new boolean[n]);
        return ans >= 100000 ? -1 : ans;
    }

    public int dfs(List<List<Pair>> graph, int start, int dst, int k, boolean vis[]) {

        if (start == dst) {
            return 0;
        }
        if (k < 0) return 100000;

        int price = Integer.MAX_VALUE;

        for (Pair p : graph.get(start)) {
            int node = p.to;
            if (!vis[node]) {
                price = Math.min(price, dfs(graph, node, dst, k - 1, vis) + p.price);
            }
        }
        return price;
    }

    static class Pair {
        int to;
        int price;

        public Pair(int to, int price) {
            this.to = to;
            this.price = price;
        }
    }
}