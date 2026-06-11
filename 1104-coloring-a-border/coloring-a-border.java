class Solution {

    List<int[]> border = new ArrayList<>();

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean vis[][] = new boolean[grid.length][grid[0].length];

        int original = grid[row][col];

        dfs(grid, row, col, vis, color, original);
        for (int[] cell : border) {
            grid[cell[0]][cell[1]] = color;
        }

        return grid;
    }

    public void dfs(int grid[][], int i, int j, boolean vis[][],
                    int color, int original) {

        vis[i][j] = true;

        if (check(grid, i, j, original)) {
            border.add(new int[]{i, j});
        }

        // up
        if (inside(grid, i - 1, j) &&
            !vis[i - 1][j] &&
            grid[i - 1][j] == original) {

            dfs(grid, i - 1, j, vis, color, original);
        }

        // down
        if (inside(grid, i + 1, j) &&
            !vis[i + 1][j] &&
            grid[i + 1][j] == original) {

            dfs(grid, i + 1, j, vis, color, original);
        }

        // left
        if (inside(grid, i, j - 1) &&
            !vis[i][j - 1] &&
            grid[i][j - 1] == original) {

            dfs(grid, i, j - 1, vis, color, original);
        }

        // right
        if (inside(grid, i, j + 1) &&
            !vis[i][j + 1] &&
            grid[i][j + 1] == original) {

            dfs(grid, i, j + 1, vis, color, original);
        }
    }

    public boolean check(int grid[][], int i, int j, int original) {
        if (i == 0 || j == 0 ||
            i == grid.length - 1 ||
            j == grid[0].length - 1) {
            return true;
        }
        if (grid[i + 1][j] != original ||
            grid[i - 1][j] != original ||
            grid[i][j + 1] != original ||
            grid[i][j - 1] != original) {
            return true;
        }

        return false;
    }

    public boolean inside(int grid[][], int i, int j) {
        return i >= 0 &&
               i < grid.length &&
               j >= 0 &&
               j < grid[0].length;
    }
}