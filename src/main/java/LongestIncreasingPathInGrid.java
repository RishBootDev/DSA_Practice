public class LongestIncreasingPathInGrid {

    private int max = Integer.MIN_VALUE;
    private Integer dp[][];


    // this was my approach and it correctly solved the problem
    public int longestIncreasingPath(int[][] matrix) {

        dp = new Integer[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, helper(matrix, i, j));
            }
        }

        return max;
    }

    public int helper(int [][] mat, int i, int j) {

        int path1 = 0;
        int path2 = 0;
        int path3 = 0;
        int path4 = 0;

        if(dp[i][j] != null) return dp[i][j];

        // move up
        if(checkBoundary(mat, i - 1, j)) {

            if(mat[i-1][j] > mat[i][j]) {
                path1 = helper(mat, i - 1, j);
            }
        }

        // move down
        if(checkBoundary(mat, i + 1, j)) {

            if(mat[i+1][j] > mat[i][j]) {
                path2 = helper(mat, i + 1, j);
            }
        }

        // move left
        if(checkBoundary(mat, i , j - 1)) {

            if(mat[i][j-1] > mat[i][j]) {
                path3 = helper(mat, i, j - 1);
            }
        }

        // move right
        if(checkBoundary(mat, i, j + 1)) {

            if(mat[i][j+1] > mat[i][j]) {
                path4 = helper(mat, i, j + 1);
            }
        }

        return dp[i][j] = 1 + Math.max(path1,Math.max(path2,Math.max(path3, path4)));
    }

    public boolean checkBoundary(int mat[][], int i, int j) {

        int m = mat.length;
        int n = mat[0].length;
        if(i == m || j == n)
            return false;
        if(i < 0 || j < 0)
            return false;
        return true;
    }
}
