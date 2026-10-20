class Solution {

    public double maxProbability(int n, int[][] edges, double[] succ, int start, int end) {

        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new Pair(edges[i][1], succ[i]));
            graph.get(edges[i][1]).add(new Pair(edges[i][0], succ[i]));
        }

        return dijkstra(graph, start)[end];
    }
    public double[] dijkstra(List<List<Pair>> graph, int start) {

        double ans[] = new double[graph.size()];
        Arrays.fill(ans, 0.0);

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (p1, p2) -> Double.compare(p2.wt, p1.wt)
        );

        pq.add(new Pair(start, 1.0));
        boolean vis[] = new boolean[graph.size()];
        ans[start] = 1.0;

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            if(vis[curr.dest]) continue;
            vis[curr.dest] = true;

            for(Pair pair : graph.get(curr.dest)) {
                if(!vis[pair.dest]) {
                    if(ans[curr.dest] * pair.wt > ans[pair.dest]) {
                        ans[pair.dest] = ans[curr.dest] * pair.wt;
                        pq.add(new Pair(pair.dest, ans[pair.dest]));
                    }
                }
            }
        }
        return ans;
    }

    static class Pair{
        int dest;
        double wt;
        public Pair(int dest, double wt) {
            this.dest = dest;
            this.wt = wt;
        }
    }
}