import java.util.Arrays;

public class MinPathSum {

    public int minPathSum(int[][] grid) {

        int dp[][] = new int[grid.length][grid[0].length];
        for(int d[] : dp) Arrays.fill(d, -1);

        return helper(grid, 0, 0, dp);
    }

    public int helper(int [][]grid, int i , int j, int[][] dp) {
        if(i == grid.length -1 && j == grid[0].length -1) return grid[i][j];

        if(dp[i][j] != -1) return dp[i][j];

        int right = Integer.MAX_VALUE;;
        if(j + 1 < grid[i].length) right = helper(grid, i, j+1, dp);
        int left = Integer.MAX_VALUE;
        if(i + 1 < grid.length) left = helper(grid, i + 1, j, dp);

        return dp[i][j] = Math.min(right, left) + grid[i][j];
    }

    public int minPathSum2(int[][] grid) {

        return helper2(grid, 0, 0);
    }

    public int helper2(int [][]grid, int i , int j) {
        if(i == grid.length -1 && j == grid[0].length -1) return grid[i][j];

        int right = Integer.MAX_VALUE;;
        if(j + 1 < grid[i].length) right = helper2(grid, i, j+1);
        int left = Integer.MAX_VALUE;
        if(i + 1 < grid.length) left = helper2(grid, i + 1, j);

        return Math.min(right, left) + grid[i][j];
    }
}
