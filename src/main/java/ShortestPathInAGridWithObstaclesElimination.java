public class ShortestPathInAGridWithObstaclesElimination {

    private Integer dp[][][];
    public int shortestPath(int[][] grid, int k) {
        this.dp = new Integer[grid.length][grid[0].length][k + 1];
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans = helper(grid, 0, 0, k, visited);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int helper(int[][] grid, int i, int j, int k, boolean[][] visited) {

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return 0;
        }
        if(dp[i][j][k] != null) return dp[i][j][k];
        visited[i][j] = true;

        int min = Integer.MAX_VALUE;

        if (inside(grid, i + 1, j) && !visited[i + 1][j]) {

            if (grid[i + 1][j] == 1 && k > 0) {
                int down = helper(grid, i + 1, j, k - 1, visited);
                if (down != Integer.MAX_VALUE)
                    min = Math.min(min, down + 1);
            }

            if (grid[i + 1][j] == 0) {
                int down = helper(grid, i + 1, j, k, visited);
                if (down != Integer.MAX_VALUE)
                    min = Math.min(min, down + 1);
            }
        }
        if (inside(grid, i - 1, j) && !visited[i - 1][j]) {

            if (grid[i - 1][j] == 1 && k > 0) {
                int up = helper(grid, i - 1, j, k - 1, visited);
                if (up != Integer.MAX_VALUE)
                    min = Math.min(min, up + 1);
            }

            if (grid[i - 1][j] == 0) {
                int up = helper(grid, i - 1, j, k, visited);
                if (up != Integer.MAX_VALUE)
                    min = Math.min(min, up + 1);
            }
        }
        if (inside(grid, i, j + 1) && !visited[i][j + 1]) {

            if (grid[i][j + 1] == 1 && k > 0) {
                int right = helper(grid, i, j + 1, k - 1, visited);
                if (right != Integer.MAX_VALUE)
                    min = Math.min(min, right + 1);
            }

            if (grid[i][j + 1] == 0) {
                int right = helper(grid, i, j + 1, k, visited);
                if (right != Integer.MAX_VALUE)
                    min = Math.min(min, right + 1);
            }
        }

        if (inside(grid, i, j - 1) && !visited[i][j - 1]) {

            if (grid[i][j - 1] == 1 && k > 0) {
                int left = helper(grid, i, j - 1, k - 1, visited);
                if (left != Integer.MAX_VALUE)
                    min = Math.min(min, left + 1);
            }

            if (grid[i][j - 1] == 0) {
                int left = helper(grid, i, j - 1, k, visited);
                if (left != Integer.MAX_VALUE)
                    min = Math.min(min, left + 1);
            }
        }
        visited[i][j] = false;

        return dp[i][j][k] = min;
    }

    public boolean inside(int[][] grid, int i, int j) {
        return i >= 0 &&
                j >= 0 &&
                i < grid.length &&
                j < grid[0].length;
    }
}