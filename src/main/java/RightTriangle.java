import java.util.HashSet;
import java.util.Set;

public class RightTriangle {

    public long numberOfRightTriangles(int[][] grid) {

        Set<String> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    if (check(grid, i - 1, j) && check(grid, i, j - 1)) {
                        if (grid[i - 1][j] == 1 && grid[i][j - 1] == 1) count++;
                    }
                    if (check(grid, i + 1, j) && check(grid, i, j - 1)) {
                        if (grid[i + 1][j] == 1 && grid[i][j - 1] == 1) count++;
                    }
                    if (check(grid, i - 1, j) && check(grid, i, j + 1)) {
                        if (grid[i - 1][j] == 1 && grid[i][j + 1] == 1) count++;
                    }
                    if (check(grid, i + 1, j) && check(grid, i, j + 1)) {
                        if (grid[i + 1][j] == 1 && grid[i][j + 1] == 1) count++;
                    }
                }
            }
        }
        return count;
    }
    public boolean check(int [][] grid, int i, int j) {
        if(i >= grid.length || j >= grid[0].length) return false;
        if(i < 0 || j < 0) return false;
        return true;
    }

}
