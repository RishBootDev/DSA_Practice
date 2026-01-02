public class DiagonalTraverse {

        private int[] res;
        private int itr, dir;

        public int[] findDiagonalOrder(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            res = new int[m * n];
            itr = 0;
            dir = 1;
            traverse(0, 0, mat, m, n);
            return res;
        }

        private void traverse(int i, int j, int[][] grid, int m, int n) {
            if (itr == m * n) return;

            res[itr++] = grid[i][j];

            int newI = i, newJ = j;

            if (dir == 1) {
                newI = i - 1;
                newJ = j + 1;
            } else {
                newI = i + 1;
                newJ = j - 1;
            }

            if (newI < 0 && newJ < n) {
                newI = 0;
                dir = -1;
            } else if (newJ == n) {
                newI = i + 1;
                newJ = n - 1;
                dir = -1;
            } else if (newJ < 0 && newI < m) {
                newJ = 0;
                dir = 1;
            } else if (newI == m) {
                newI = m - 1;
                newJ = j + 1;
                dir = 1;
            }

            traverse(newI, newJ, grid, m, n);
        }
}

