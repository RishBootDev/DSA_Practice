public class MaximumMatrixSum {

    public long maxMatrixSum(int[][] matrix) {

        int count = 0;
        int min = Integer.MAX_VALUE;
        long sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 0) count++;

                int absVal = Math.abs(matrix[i][j]);
                sum += absVal;
                min = Math.min(min, absVal);
            }
        }

        if (count % 2 == 0) return sum;
        else return sum - 2L * min;
    }
}
