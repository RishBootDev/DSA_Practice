public class MaximumScorePathGridCost {


    // this is a correct approach but it got me time limit exceeded
    // to solve this we need 3d DP

        Integer[][][] dp;

        public int maxPathScore(int[][] grid, int k) {

            int m = grid.length;
            int n = grid[0].length;

            dp = new Integer[m][n][k + 1];
            int ans = helper(grid, k, 0, 0, 0);
            return ans < 0 ? -1 : ans;
        }

        public int helper(int[][] grid, int k, int i, int j, int cost) {

            if (i >= grid.length || j >= grid[0].length) {
                return -1000000;
            }
            int newCost = cost;

            if (grid[i][j] != 0) {
                newCost++;
            }
            if (newCost > k) {
                return -1000000;
            }

            if (dp[i][j][newCost] != null) {
                return dp[i][j][newCost];
            }
            if (i == grid.length - 1 && j == grid[0].length - 1) {
                return dp[i][j][newCost] = grid[i][j];
            }
            int right = helper(grid, k, i, j + 1, newCost);
            int down = helper(grid, k, i + 1, j, newCost);
            int best = Math.max(right, down);
            return dp[i][j][newCost] = grid[i][j] + best;
        }

}
