public class ColorBorder {

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
         boolean vis[][] = new boolean[grid.length][grid[0].length];
         dfs(grid, row, col, vis,color);
         return grid;
    }

    public void dfs(int grid[][] , int i, int j, boolean vis[][], int color) {
        vis[i][j] = true;
        int temp = grid[i][j];
        if(check(grid, i , j)) grid[i][j] = color;

        // up
        if(inside(grid, i -1, j) && !vis[i - 1][j] && grid[i - 1][j] == temp) {
            dfs(grid, i - 1, j, vis, color);
            vis[i - 1][j] = true;
        }
        // down
        if(inside(grid, i + 1, j) && !vis[i + 1][j] && grid[i + 1][j] == temp) {
            dfs(grid, i + 1, j, vis, color);
            vis[i + 1][j] = true;
        }
        // left
        if(inside(grid, i, j-1) && !vis[i][j-1] && grid[i][j - 1] == temp) {
            dfs(grid, i, j-1, vis, color);
            vis[i][j-1] = true;
        }
        // right
        if(inside(grid, i, j+1) && !vis[i][j+1] && grid[i][j+1] == temp) {
            dfs(grid, i, j+1, vis, color);
            vis[i][j+1] = true;
        }

    }
    public boolean check(int grid[][], int i, int j) {
        if(!inside(grid, i, j)) return false;
        int temp = grid[i][j];
        if(inside(grid, i + 1, j) && temp != grid[i + 1][j] ||
           inside(grid, i - 1, j) && temp != grid[i - 1][j] ||
           inside(grid, i, j + 1) && temp != grid[i][j+ 1] ||
           inside(grid, i , j - 1) && temp != grid[i][j - 1]
        ) return true;
        return false;
    }
    public boolean inside(int grid[][], int i, int j) {
        if(i >= 0 && i <= grid.length && j >= 0 && j <= grid[0].length)
            return true;
        return false;
    }
}
