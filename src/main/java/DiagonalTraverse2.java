import java.util.Arrays;
import java.util.List;

public class DiagonalTraverse2 {

    static class Pair{
        int row;
        int col;
        int data;

        public Pair(int row, int col, int data) {
            this.row = row;
            this.col = col;
            this.data = data;
        }
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {

        int k = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {

                k++;
            }
        }

        int n = 0;
        Pair [] pairs = new Pair[k];
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                Pair pair = new Pair(i, j, nums.get(i).get(j));
                pairs[n] = pair;
                n++;
            }
        }

        Arrays.sort(pairs, (a,b)->{
            int suma = a.col + a.row;
            int sumb = b.col + b.row;

            if(suma == sumb) return b.row - a.row;
            return suma - sumb;
        });

        int [] ans = new int[n];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = pairs[i].data;
        }
        return ans;
    }

}
