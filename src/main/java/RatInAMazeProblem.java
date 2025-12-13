public class RatInAMazeProblem {

    public static void main(String[] args) {

        int mat[][] = {
                {1,1,1,0},
                {1,0,1,1},
                {1,1,1,1},
                {0,1,1,1}
        };

        int n = mat.length;
        int m = mat[0].length;

        boolean vis[][] = new boolean[n][m];

        if(mat[0][0] == 1){
            vis[0][0] = true;
            ratInaMaze(mat, vis, 0, 0, "", n, m);
        }
    }

    public static boolean isValid(int[][] mat, boolean[][] vis, int i, int j, int n, int m){
        return (i >= 0 && i < n &&
                j >= 0 && j < m &&
                mat[i][j] == 1 &&
                !vis[i][j]);
    }

    public static void ratInaMaze(int[][] mat, boolean[][] vis,
                                  int i, int j, String path,
                                  int n, int m){

        if(i == n-1 && j == m-1){
            System.out.println(path);
            return;
        }

        // Down
        if(isValid(mat, vis, i+1, j, n, m)){
            vis[i+1][j] = true;
            ratInaMaze(mat, vis, i+1, j, path + 'D', n, m);
            vis[i+1][j] = false;
        }

        // Left
        if(isValid(mat, vis, i, j-1, n, m)){
            vis[i][j-1] = true;
            ratInaMaze(mat, vis, i, j-1, path + 'L', n, m);
            vis[i][j-1] = false;
        }

        // Right
        if(isValid(mat, vis, i, j+1, n, m)){
            vis[i][j+1] = true;
            ratInaMaze(mat, vis, i, j+1, path + 'R', n, m);
            vis[i][j+1] = false;
        }

        // Up
        if(isValid(mat, vis, i-1, j, n, m)){
            vis[i-1][j] = true;
            ratInaMaze(mat, vis, i-1, j, path + 'U', n, m);
            vis[i-1][j] = false;
        }
    }
}
