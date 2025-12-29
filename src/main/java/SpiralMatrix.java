import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        int a = 0;
        int b = matrix[0].length - 1;
        int c = matrix.length - 1;
        int d = 0;

        while (a <= c && d <= b) {

            for (int i = d; i <= b; i++) {
                list.add(matrix[a][i]);
            }
            a++;

            for (int i = a; i <= c; i++) {
                list.add(matrix[i][b]);
            }
            b--;

            if (a <= c) {
                for (int i = b; i >= d; i--) {
                    list.add(matrix[c][i]);
                }
                c--;
            }

            if (d <= b) {
                for (int i = c; i >= a; i--) {
                    list.add(matrix[i][d]);
                }
                d++;
            }
        }

        return list;
    }

    // Spiral Order matrix second question
    public int[][] generateMatrix(int n) {

        int matrix[][] = new int[n][n];

        int a = 0;
        int b = matrix[0].length - 1;
        int c = matrix.length - 1;
        int d = 0;
        int temp = 1;

        while (a <= c && d <= b) {

            for (int i = d; i <= b; i++) {
                matrix[a][i] = temp++;
            }
            a++;

            for (int i = a; i <= c; i++) {
                matrix[i][b] = temp++;
            }
            b--;

            if (a <= c) {
                for (int i = b; i >= d; i--) {
                    matrix[c][i] = temp++;
                }
                c--;
            }

            if (d <= b) {
                for (int i = c; i >= a; i--) {
                    matrix[i][d] = temp++;
                }
                d++;
            }
        }

        return matrix;
    }
}
