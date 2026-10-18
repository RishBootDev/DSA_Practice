public class NumberOfClosedIslands {

    public int closedIsland(int[][] grid) {

        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!vis[i][j] && grid[i][j] == 0) {
                    if (helper(grid, i, j, vis)) count++;
                }
            }
        }
        return count;
    }

    public boolean helper(int [][] grid, int i, int j, boolean vis[][]) {
        if (!check(grid, i, j)) return true;

        vis[i][j] = true;

        boolean ans = true;

        // move up
        if (i > 0 && !vis[i - 1][j] && grid[i - 1][j] == 0) {
            ans &= helper(grid, i - 1, j, vis);
        } else if (i == 0) {
            ans = false;
        }

        // move down
        if (i < grid.length - 1 && !vis[i + 1][j] && grid[i + 1][j] == 0) {
            ans &= helper(grid, i + 1, j, vis);
        } else if (i == grid.length - 1) {
            ans = false;
        }

        // move left
        if (j > 0 && !vis[i][j - 1] && grid[i][j - 1] == 0) {
            ans &= helper(grid, i, j - 1, vis);
        } else if (j == 0) {
            ans = false;
        }

        // move right
        if (j < grid[0].length - 1 && !vis[i][j + 1] && grid[i][j + 1] == 0) {
            ans &= helper(grid, i, j + 1, vis);
        } else if (j == grid[0].length - 1) {
            ans = false;
        }

        return ans;
    }

    public boolean check(int grid[][], int i, int j) {
        if (i < 0 || j < 0) return false;
        if (i >= grid.length || j >= grid[0].length) return false;
        if (grid[i][j] == 1) return false;
        return true;
    }

}
