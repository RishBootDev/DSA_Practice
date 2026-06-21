class Solution {
    public long countPairs(int n, int[][] edges) {
        
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] visited = new boolean[n];
        int[] sizes = new int[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                sizes[i] = dfs(i, graph, visited);
            }
        }

        long ans = 0;
        long sum = 0;
        for (int size : sizes) {
            ans += sum * size;
            sum += size;
        }

        return ans;
    }

    private int dfs(int u, List<Integer>[] graph, boolean[] visited) {
        visited[u] = true;
        int size = 1;
        for (int v : graph[u]) {
            if (!visited[v]) {
                size += dfs(v, graph, visited);
            }
        }
        return size;
    }
}