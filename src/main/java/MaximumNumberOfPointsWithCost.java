public class MaximumNumberOfPointsWithCost {

    public long maxPoints(int[][] points) {

        long max = Long.MIN_VALUE;
        for (int i = 0; i < points[0].length; i++) {
            long total = helper(points, 0, i);
            max = Math.max(max, total);
        }
        return max;
    }
    public long helper(int [][] points, int i, int j) {
        if(i + 1 == points.length) return 0;

        int [] pp = points[i + 1];
        long max = Long.MIN_VALUE;

        for (int k = 0; k < pp.length; k++) {
            long total = helper(points, i + 1, k) + points[i][j]
                    + Math.abs(j - k) ;
            max = Math.max(total, max);
        }
        return max;
    }
}
