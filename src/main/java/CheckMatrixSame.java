import java.util.Arrays;

public class CheckMatrixSame {

    public static void main(String[] args) {
        int mat1[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 8}
        };

        int mat2[][] = {{4, 5, 6},
                {1, 2, 3},
                {7, 8, 9}
        };

        System.out.println(check(mat1, mat2));
    }

    public static boolean check(int [][] mat1, int [][] mat2) {
        if(mat1.length != mat2.length) return false;
        if(mat1[0].length != mat2[0].length) return false;

        for (int i = 0; i < mat1.length; i++) {
            Arrays.sort(mat1[i]);
            Arrays.sort(mat2[i]);
        }

        Arrays.sort(mat1,(a,b)->a[0] - b[0]);
        Arrays.sort(mat2,(a,b)->a[0] - b[0]);

        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                if(mat1[i][j] != mat2[i][j]) return false;
            }
        }
        return true;
    }
}
