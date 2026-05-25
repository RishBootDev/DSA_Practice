public class OutOfBoundaryPaths {


    // this recursion worked great but got me time limit exceeded errors due to the tough constraints
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        return helper(m, n, startRow, startColumn, maxMove);
    }
    public int helper(int m, int n , int i, int j, int mm) {

        if(i == m || j == n || i == -1 || j == -1) return 1;
        if(mm == 0) return 0;

        int count = 0;
        // move left
        count += helper(m, n, i - 1, j, mm - 1);
        // move right
        count += helper(m, n, i + 1, j, mm - 1);

        // move up
        count += helper(m, n, i, j - 1, mm - 1);
        // move down
        count += helper(m, n, i, j + 1, mm - 1);

        return count;
    }


    // this is the solution involving the dynamic programming usually memoization
    Integer dp[][][];

    public int findPaths2(int m, int n, int maxMove, int startRow, int startColumn) {
        return helper2(m, n, startRow, startColumn, maxMove);
    }
    public int helper2(int m, int n , int i, int j, int mm) {

        if(i == m || j == n || i == -1 || j == -1) return 1;
        if(mm == 0) return 0;

        if(dp[i][j][m] != null) return dp[i][j][m];
        int count = 0;
        // move left
        count += helper2(m, n, i - 1, j, mm - 1);
        // move right
        count += helper2(m, n, i + 1, j, mm - 1);

        // move up
        count += helper2(m, n, i, j - 1, mm - 1);
        // move down
        count += helper2(m, n, i, j + 1, mm - 1);

        return dp[i][j][m] = count;
    }
}
