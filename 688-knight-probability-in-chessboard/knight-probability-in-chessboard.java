class Solution {

    Double dp [][][];
    
    public double knightProbability(int n, int k, int row, int column) {
        this.dp = new Double[n][n][k+1];
        return helper(n, row, column, k);
    }

    public double helper(int n, int i, int j, int k) {

        if (i < 0 || i >= n || j < 0 || j >= n) {
            return 0;
        }

        if (k == 0) {
            return 1;
        }
        if(dp[i][j][k] != null) return dp[i][j][k];
        
        double ans = 0;

        ans += helper(n, i - 1, j - 2, k - 1);
        ans += helper(n, i - 2, j - 1, k - 1);

        ans += helper(n, i + 1, j - 2, k - 1);
        ans += helper(n, i + 2, j - 1, k - 1);

        ans += helper(n, i - 1, j + 2, k - 1);
        ans += helper(n, i - 2, j + 1, k - 1);

        ans += helper(n, i + 1, j + 2, k - 1);
        ans += helper(n, i + 2, j + 1, k - 1);

        return dp[i][j][k] = ans / 8.0;
    }
}