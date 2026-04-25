


//  this approach works fine but passes only 17 out of 20 test cases for this  problem
public class RandomFlipMatrix {

    int[][] mat;
    int i, j;

    public RandomFlipMatrix(int m, int n) {
        mat = new int[m][n];
        this.i = 0;
        this.j = 0;
    }

    public int[] flip() {

        mat[i][j] = 1;
        int[] ans = {i, j};

        if (j == mat[0].length - 1) {
            j = 0;
            i++;
        } else {
            j++;
        }

        if (i == mat.length) {
            i = 0;
            j = 0;
        }

        return ans;
    }

    public void reset() {
        i = 0;
        j = 0;
        mat = new int[mat.length][mat[0].length];
    }
}
