class Solution {

    Integer[][][] dp;
    int MOD = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        dp = new Integer[m][n][maxMove + 1];
        return helper(m, n, startRow, startColumn, maxMove);
    }

    public int helper(int m, int n, int i, int j, int mm) {

        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 1;
        }
        if (mm == 0) {
            return 0;
        }
        if (dp[i][j][mm] != null) {
            return dp[i][j][mm];
        }

        long count = 0;

        count += helper(m, n, i - 1, j, mm - 1);
        count += helper(m, n, i + 1, j, mm - 1);
        count += helper(m, n, i, j - 1, mm - 1);
        count += helper(m, n, i, j + 1, mm - 1);

        return dp[i][j][mm] = (int)(count % MOD);
    }
}