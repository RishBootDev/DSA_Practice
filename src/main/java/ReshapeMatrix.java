import java.util.ArrayList;
import java.util.List;

public class ReshapeMatrix {

    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int m = mat.length;
        int n = mat[0].length;

        if (m * n != r * c) return mat;

        int[][] ans = new int[r][c];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.add(mat[i][j]);
            }
        }

        int temp = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[i][j] = list.get(temp++);
            }
        }

        return ans;
    }
}
