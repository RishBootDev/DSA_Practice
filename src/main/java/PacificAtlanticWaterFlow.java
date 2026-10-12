import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        boolean pacific[][] = new boolean[m][n];
        boolean atlantic[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfsPacific(heights, i, 0, pacific);
            dfsAtlantic(heights, i, n - 1, atlantic);
        }

        for (int j = 0; j < n; j++) {
            dfsPacific(heights, 0, j, pacific);
            dfsAtlantic(heights, m - 1, j, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }

        return ans;
    }

    public void dfsPacific(int[][] grid, int x, int y, boolean[][] vis) {

        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return;
        if (vis[x][y]) return;

        vis[x][y] = true;

        if (x + 1 < grid.length && grid[x + 1][y] >= grid[x][y])
            dfsPacific(grid, x + 1, y, vis);

        if (x - 1 >= 0 && grid[x - 1][y] >= grid[x][y])
            dfsPacific(grid, x - 1, y, vis);

        if (y + 1 < grid[0].length && grid[x][y + 1] >= grid[x][y])
            dfsPacific(grid, x, y + 1, vis);

        if (y - 1 >= 0 && grid[x][y - 1] >= grid[x][y])
            dfsPacific(grid, x, y - 1, vis);
    }

    public void dfsAtlantic(int[][] grid, int x, int y, boolean[][] vis) {

        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return;
        if (vis[x][y]) return;

        vis[x][y] = true;

        if (x + 1 < grid.length && grid[x + 1][y] >= grid[x][y])
            dfsAtlantic(grid, x + 1, y, vis);

        if (x - 1 >= 0 && grid[x - 1][y] >= grid[x][y])
            dfsAtlantic(grid, x - 1, y, vis);

        if (y + 1 < grid[0].length && grid[x][y + 1] >= grid[x][y])
            dfsAtlantic(grid, x, y + 1, vis);

        if (y - 1 >= 0 && grid[x][y - 1] >= grid[x][y])
            dfsAtlantic(grid, x, y - 1, vis);
    }
}