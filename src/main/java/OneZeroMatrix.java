public class OneZeroMatrix {

    // this is a first intuition of solving it using dynamic programming
    public int[][] updateMatrix(int[][] mat) {

        int[][] ans = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {

                boolean[][] vis =
                        new boolean[mat.length][mat[0].length];
                int dist = helper(mat, i, j, vis);
                ans[i][j] = dist;
            }
        }
        return ans;
    }

    public int helper(int[][] mat, int i, int j, boolean[][] vis) {

        if (i < 0 || j < 0 ||
                i >= mat.length || j >= mat[0].length) {
            return 10000;
        }
        if (mat[i][j] == 0) {
            return 0;
        }
        if (vis[i][j]) {
            return 10000;
        }
        vis[i][j] = true;

        int up = helper(mat, i - 1, j, vis);
        int left = helper(mat, i, j - 1, vis);
        int right = helper(mat, i + 1, j, vis);
        int down = helper(mat, i, j + 1, vis);

        vis[i][j] = false;
        return Math.min(up, Math.min(left, Math.min(right, down))) + 1;
    }
}
