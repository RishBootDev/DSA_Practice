class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < matrix.length; i++){
            HashSet<Integer> row_set = new HashSet<>();
            HashSet<Integer> col_set = new HashSet<>();
            for(int j = 0; j < matrix[i].length; j++){
                row_set.add(matrix[i][j]);
                col_set.add(matrix[j][i]);
            }
            if(row_set.size() != n || col_set.size() != n){
                return false;
            }
        }
        return true;
    }
}