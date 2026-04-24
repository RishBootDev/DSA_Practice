import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DivideIntervalsIntoMinimumNumberOfGroups {

    public int minGroups(int[][] intervals) {
        List<Pair> pairs = new ArrayList<>();
        pairs.sort((p1, p2)->p1.end - p2.end);

        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < pairs.size() - 1; i++) {
            Pair first = pairs.get(i);
            Pair second = pairs.get(i+1);

            if(second.start <= first.end){
                count++;
            }else {
                max = Math.max(count, max);
                count = 0;
            }
        }

        max = Math.max(count, max);

        return max + 1;
    }
    static class Pair{
        int start;
        int end;

        @Override
        public String toString() {
            return "Pair{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
