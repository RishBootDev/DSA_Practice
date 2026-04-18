import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsToLetterYOnGrid {


        public int minimumOperationsToWriteY(int[][] g) {
            int n = g.length;

            int[] y = new int[3];
            int[] ny = new int[3];

            int ty = 0, tny = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (isY(i, j, n)) {
                        y[g[i][j]]++;
                        ty++;
                    } else {
                        ny[g[i][j]]++;
                        tny++;
                    }
                }
            }

            int ans = Integer.MAX_VALUE;

            for (int a = 0; a < 3; a++) {
                for (int b = 0; b < 3; b++) {

                    if (a == b) continue;

                    int ops = (ty - y[a]) + (tny - ny[b]);

                    ans = Math.min(ans, ops);
                }
            }

            return ans;
        }

        private boolean isY(int i, int j, int n) {
            int m = n / 2;

            if (i <= m && i == j) return true;
            if (i <= m && i + j == n - 1) return true;
            if (i >= m && j == m) return true;

            return false;
        }
    }
