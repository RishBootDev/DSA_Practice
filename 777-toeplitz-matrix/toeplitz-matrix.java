class Solution {
     public boolean isToeplitzMatrix(int[][] matrix) {
        int mult = matrix.length * matrix[0].length;
        int temp = mult % 2 == 0 ? mult/2 : (mult + 1)/2;

        int row = matrix.length - 1;
        int col = 0;
        for (int i = 0; i < temp; i++) {
            Set<Integer> set = new HashSet<>();

            int x = row;
            int y = col;
            while(x < matrix.length && y < matrix[0].length) {
                set.add(matrix[x++][y++]);
            }
            if(set.size() > 1) return false;
            if(row == 0) {
                col++;
            }else {
                row--;
            }
        }
        return true;
    }
     
}