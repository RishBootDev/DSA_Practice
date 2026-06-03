public class ShortestBridgeBetweenGraph {


        public int shortestBridge(int[][] grid) {

            boolean[][] vis = new boolean[grid.length][grid[0].length];

            boolean found = false;

            for (int i = 0; i < grid.length && !found; i++) {
                for (int j = 0; j < grid[0].length && !found; j++) {

                    if (grid[i][j] == 1) {
                        dfsGraph(grid, i, j, vis);
                        found = true;
                    }
                }
            }

            int[] min = { Integer.MAX_VALUE };

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {

                    if (vis[i][j]) {

                        boolean[][] vis2 = new boolean[grid.length][grid[0].length];

                        for (int r = 0; r < grid.length; r++) {
                            vis2[r] = vis[r].clone();
                        }

                        dfs(grid, i - 1, j, vis2, 0, min);
                        dfs(grid, i + 1, j, vis2, 0, min);
                        dfs(grid, i, j - 1, vis2, 0, min);
                        dfs(grid, i, j + 1, vis2, 0, min);
                    }
                }
            }

            return min[0];
        }

        public void dfsGraph(int[][] grid, int i, int j, boolean[][] vis) {

            if (!inside(grid, i, j) || vis[i][j] || grid[i][j] == 0)
                return;

            vis[i][j] = true;

            dfsGraph(grid, i - 1, j, vis);
            dfsGraph(grid, i + 1, j, vis);
            dfsGraph(grid, i, j - 1, vis);
            dfsGraph(grid, i, j + 1, vis);
        }

        public void dfs(int[][] grid, int i, int j,
                        boolean[][] vis, int dist, int[] min) {

            if (!inside(grid, i, j) || vis[i][j])
                return;

            if (dist >= min[0])
                return;

            if (grid[i][j] == 1) {
                min[0] = Math.min(min[0], dist);
                return;
            }

            vis[i][j] = true;

            dfs(grid, i - 1, j, vis, dist + 1, min);
            dfs(grid, i + 1, j, vis, dist + 1, min);
            dfs(grid, i, j - 1, vis, dist + 1, min);
            dfs(grid, i, j + 1, vis, dist + 1, min);

            vis[i][j] = false;
        }

        public boolean inside(int[][] grid, int i, int j) {

            return i >= 0 &&
                    j >= 0 &&
                    i < grid.length &&
                    j < grid[0].length;
        }

}
