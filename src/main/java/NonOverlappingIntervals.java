import java.util.Arrays;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int end = intervals[0][1];
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {

            int start = intervals[i][0];

            if(end <= start) {
                end = intervals[i][1];
            }else count++;
        }

        return count;
    }
}
