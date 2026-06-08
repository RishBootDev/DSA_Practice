class Solution {

    public int[] gardenNoAdj(int n, int[][] paths) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            int a = path[0];
            int b = path[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] color = new int[n + 1];
        boolean[] vis = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                dfs(graph, i, vis, color);
            }
        }

        int[] ans = new int[n];

        for (int i = 1; i <= n; i++) {
            ans[i - 1] = color[i];
        }

        return ans;
    }

    private void dfs(List<List<Integer>> graph,
                     int node,
                     boolean[] vis,
                     int[] color) {

        vis[node] = true;

        boolean[] used = new boolean[5];

        for (int neigh : graph.get(node)) {
            if (color[neigh] != 0) {
                used[color[neigh]] = true;
            }
        }

        for (int c = 1; c <= 4; c++) {
            if (!used[c]) {
                color[node] = c;
                break;
            }
        }

        for (int neigh : graph.get(node)) {
            if (!vis[neigh]) {
                dfs(graph, neigh, vis, color);
            }
        }
    }
}