public class MaximumScorePathOfGridSum {

    public int maxPathScore(int[][] grid, int k) {

        int ans = helper(grid, k, 0, 0, 0);
        return ans < 0 ? -1 : ans;
    }

    public int helper(int[][] grid, int k, int i, int j, int sum) {

        if (i >= grid.length || j >= grid[0].length) {
            return Integer.MIN_VALUE;
        }

        sum += grid[i][j];
        if (sum > k) {
            return Integer.MIN_VALUE;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        int right = helper(grid, k, i, j + 1, sum);
        int down = helper(grid, k, i + 1, j, sum);

        int best = Math.max(right, down);

        if (best == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return grid[i][j] + best;
    }
}
