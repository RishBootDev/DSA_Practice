import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortDiagonals {


    public int[][] diagonalSort(int[][] mat) {

        int start = mat.length - 1;
        int end = 0;

        while (start < mat.length && end< mat[0].length){
            List<Integer> list = new ArrayList<>();

            int i = start;
            int j = end;

            while(i < mat.length && j < mat[0].length){

                list.add(mat[i][j]);
                i++;
                j++;
            }
            Collections.sort(list);
            int temp = 0;
            i = start;
            j = end;

            while(i < mat.length && j < mat[0].length){

                mat[i][j] = list.get(temp++);
                i++;j++;
            }

            if(start > 0) {
                start--;
            }else {
                end++;
            }
        }

        return mat;
    }
}
