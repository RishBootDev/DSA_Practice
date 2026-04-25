import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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

// this is the correct solution and passes all the 20/20 test cases for the problem
class Solution519 {

    Map<Integer, Integer> map;
    int rows, cols, total;
    Random rand;

    public Solution519(int n_rows, int n_cols) {
        map = new HashMap<>();
        rand = new Random();
        rows = n_rows;
        cols = n_cols;
        total = rows * cols;
    }

    public int[] flip() {
        int r = rand.nextInt(total--);
        int x = map.getOrDefault(r, r);
        map.put(r, map.getOrDefault(total, total));
        return new int[]{x / cols, x % cols};
    }

    public void reset() {
        map.clear();
        total = rows * cols;
    }
}
