public class MaximalSquare {


    // this is the working recursion of the maximal square question
    public int maximalSquare(char[][] matrix) {

        int max = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, helper(matrix, i, j));
            }
        }
        return max * max;
    }

    public int helper(char [][]mat, int i ,int j) {
        if(i >= mat.length || j >= mat[0].length) {
            return 0;
        }

        if(mat[i][j] == '0') return 0;

        int right = helper(mat, i , j+1);
        int down = helper(mat, i + 1, j);
        int diagonal = helper(mat, i + 1, j+ 1);

        return 1 + Math.min(right, Math.min(down, diagonal));
    }

    // this is the dp solution of the maximal square

    Integer dp[][];

    public int maximalSquare2(char[][] matrix) {
        this.dp = new Integer[matrix.length][matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, helper2(matrix, i, j));
            }
        }
        return max * max;
    }

    public int helper2(char [][]mat, int i ,int j) {
        if(i >= mat.length || j >= mat[0].length) {
            return 0;
        }

        if(mat[i][j] == '0') return 0;

        if(dp[i][j] != null) return dp[i][j];

        int right = helper2(mat, i , j+1);
        int down = helper2(mat, i + 1, j);
        int diagonal = helper2(mat, i + 1, j+ 1);

        return dp[i][j] = 1 + Math.min(right, Math.min(down, diagonal));
    }
}
