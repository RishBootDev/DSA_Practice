import java.util.Arrays;

public class UniquePaths2 {


    // correct recursion now converting to memoization dp
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int dp [][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] d : dp) Arrays.fill(d, -1);

        return helper(obstacleGrid, 0, 0, dp);
    }
    public int helper(int grid[][], int i, int j, int dp[][]) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return 1;
        }

        if(dp[i][j] != -1) return dp[i][j];

        int count = 0;
        if(i+1 < grid.length && grid[i+1][j] != 1) {
            count += helper(grid, i+1, j, dp);
        }
        if (j+1 < grid[0].length && grid[i][j+1] != 1) {
            count += helper(grid, i, j+1, dp);
        }
        return dp [i][j] = count;
    }
}
