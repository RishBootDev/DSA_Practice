class Solution {
    int ans = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int dist = road[2];

            graph[u].add(new int[]{v, dist});
            graph[v].add(new int[]{u, dist});
        }

        boolean[] vis = new boolean[n + 1];
        dfs(1, graph, vis);

        return ans;
    }

    public void dfs(int node, List<int[]>[] graph, boolean[] vis) {
        vis[node] = true;

        for (int[] edge : graph[node]) {
            int nei = edge[0];
            int dist = edge[1];

            ans = Math.min(ans, dist);

            if (!vis[nei]) {
                dfs(nei, graph, vis);
            }
        }
    }
}