public class RemovedCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {

        int n = intervals.length;
        boolean[] removed = new boolean[n];

        for (int i = 0; i < n; i++) {

            int a = intervals[i][0];
            int b = intervals[i][1];

            for (int j = 0; j < n; j++) {
                if(i == j) continue;

                int c = intervals[j][0];
                int d = intervals[j][1];

                if(a >= c && b <= d) {
                    removed[i] = true;
                    break;
                }
            }
        }

        int count = 0;
        for(boolean r : removed) {
            if(!r) count++;
        }

        return count;
    }
}
