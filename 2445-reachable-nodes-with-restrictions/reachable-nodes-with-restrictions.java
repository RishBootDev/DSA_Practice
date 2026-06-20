class Solution {

    public int reachableNodes(int n, int[][] edges, int[] restricted) {

        List<List<Integer>> graph = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int x : restricted) {
            set.add(x);
        }

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] vis = new boolean[n];

        return dfs(graph, 0, set, vis);
    }

    public int dfs(List<List<Integer>> graph, int node,
                   Set<Integer> restricted, boolean[] vis) {

        if (restricted.contains(node)) {
            return 0;
        }

        vis[node] = true;

        int count = 1; 

        for (int nei : graph.get(node)) {
            if (!vis[nei]) {
                count += dfs(graph, nei, restricted, vis);
            }
        }

        return count;
    }
}