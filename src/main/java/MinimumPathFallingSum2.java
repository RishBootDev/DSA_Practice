import java.util.Arrays;

public class MinimumPathFallingSum2 {


    // i have memoized the question but it got me time limit exceeded and
    // eventually able to solve about 17 out of 18 test cases with complexity
    // of O(n3) time for the worst case
    public int minFallingPathSum(int[][] grid) {

        int n = grid.length;
        int dp[][] = new int[n][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(grid, 0, -1, dp);
    }

    public int helper(int grid[][], int i, int j, int [][] dp) {

        if (i == grid.length) return 0;
        if (dp[i][j + 1] != -1) return dp[i][j + 1];
        int min = Integer.MAX_VALUE;

        for (int k = 0; k < grid[i].length; k++) {
            if (k == j) continue;

            int sum = helper(grid, i + 1, k, dp) + grid[i][k];
            min = Math.min(min, sum);
        }

        return dp[i][j + 1] = min;
    }



    // this is the final optimized solution to the problem
    // with complexity of O(n2) and it solved the problem efficiently
    public int minFallingPathSum2(int[][] grid) {

        int n = grid.length;
        int dp[] = new int[n];

        for (int j = 0; j < n; j++) {
            dp[j] = grid[n - 1][j];
        }

        for (int i = n - 2; i >= 0; i--) {

            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            int minCol = -1;

            for (int j = 0; j < n; j++) {
                if (dp[j] < min1) {
                    min2 = min1;
                    min1 = dp[j];
                    minCol = j;
                } else if (dp[j] < min2) {
                    min2 = dp[j];
                }
            }

            int newDp[] = new int[n];

            for (int j = 0; j < n; j++) {
                if (j == minCol) {
                    newDp[j] = grid[i][j] + min2;
                } else {
                    newDp[j] = grid[i][j] + min1;
                }
            }

            dp = newDp;
        }

        int ans = Integer.MAX_VALUE;
        for (int val : dp) ans = Math.min(ans, val);

        return ans;
    }
}