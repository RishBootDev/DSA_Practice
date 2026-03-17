import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int a = newInterval[0];
        int b = newInterval[1];

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int c = intervals[i][0];
            int d = intervals[i][1];

            if (d < a) {
                list.add(new int[]{c, d});
            }
            else if (c > b) {
                list.add(new int[]{a, b});
                a = c;
                b = d;
            }
            else {
                a = Math.min(a, c);
                b = Math.max(b, d);
            }
        }
        list.add(new int[]{a, b});
        return list.toArray(new int[list.size()][]);
    }
}