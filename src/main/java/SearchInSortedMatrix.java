public class SearchInSortedMatrix {

    public boolean searchMatrix(int[][] mat, int x) {
        int row = 0;
        int cols = 0;
        while(row < mat.length){
            while(cols < mat[0].length){
                if(mat[row][cols] == x){
                    return true;
                }
                cols++;
            }
            cols = 0;
            row++;
        }
        return false;

    }
}
