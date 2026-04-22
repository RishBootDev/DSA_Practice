import java.util.Arrays;

public class MinimumFallingPathSum {


    // this is the first approach and i got time limit exceeded for this
    public int minFallingPathSum(int[][] matrix) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            min = Math.min(helper(matrix, 0, i), min);
        }
        return min;
    }

    public int helper(int grid[][], int i , int j) {

        if (i == grid.length - 1) return grid[i][j];

        int left = Integer.MAX_VALUE;
        if (j > 0) left = helper(grid, i + 1, j - 1);

        int right = Integer.MAX_VALUE;
        if (j < grid[i].length - 1) right = helper(grid, i + 1, j + 1);

        int bottom = helper(grid, i + 1, j);

        return Math.min(left, Math.min(right, bottom)) + grid[i][j];
    }


    // final optimized approach using dynamic programming
    public int minFallingPathSum2(int[][] matrix) {

        int n = matrix.length;
        int dp [][] = new int[n][n];

        for(int []d : dp) Arrays.fill(dp, -1);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            min = Math.min(helper2(matrix, 0, i, dp), min);
        }
        return min;
    }

    public int helper2(int grid[][], int i , int j, int dp[][]) {

        if (i == grid.length - 1) return grid[i][j];

        if(dp[i][j] != -1) return dp[i][j];

        int left = Integer.MAX_VALUE;
        if (j > 0) left = helper2(grid, i + 1, j - 1, dp);

        int right = Integer.MAX_VALUE;
        if (j < grid[i].length - 1) right = helper2(grid, i + 1, j + 1, dp);

        int bottom = helper2(grid, i + 1, j, dp);

        return dp[i][j] = Math.min(left, Math.min(right, bottom)) + grid[i][j];
    }
}
