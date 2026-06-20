class Solution {

    public int uniquePathsIII(int[][] grid) {

        int startI = 0;
        int startJ = 0;
        int cells = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] != -1) {
                    cells++;
                }

                if (grid[i][j] == 1) {
                    startI = i;
                    startJ = j;
                }
            }
        }

        boolean[][] vis = new boolean[grid.length][grid[0].length];
        vis[startI][startJ] = true;

        return helper(grid, startI, startJ, vis, cells);
    }

    public int helper(int[][] grid, int i, int j,
                      boolean[][] vis, int remaining) {

        if (grid[i][j] == 2) {
            return remaining == 1 ? 1 : 0;
        }

        int up = 0, down = 0, left = 0, right = 0;

        if (check(grid, i - 1, j) &&
                !vis[i - 1][j] &&
                grid[i - 1][j] != -1) {

            vis[i - 1][j] = true;
            up = helper(grid, i - 1, j, vis, remaining - 1);
            vis[i - 1][j] = false;
        }

        if (check(grid, i + 1, j) &&
                !vis[i + 1][j] &&
                grid[i + 1][j] != -1) {

            vis[i + 1][j] = true;
            down = helper(grid, i + 1, j, vis, remaining - 1);
            vis[i + 1][j] = false;
        }

        if (check(grid, i, j - 1) &&
                !vis[i][j - 1] &&
                grid[i][j - 1] != -1) {

            vis[i][j - 1] = true;
            left = helper(grid, i, j - 1, vis, remaining - 1);
            vis[i][j - 1] = false;
        }

        if (check(grid, i, j + 1) &&
                !vis[i][j + 1] &&
                grid[i][j + 1] != -1) {

            vis[i][j + 1] = true;
            right = helper(grid, i, j + 1, vis, remaining - 1);
            vis[i][j + 1] = false;
        }

        return up + down + left + right;
    }

    public boolean check(int[][] grid, int i, int j) {

        if (i < 0 || j < 0 ||
                i >= grid.length ||
                j >= grid[0].length) {
            return false;
        }

        return true;
    }
}