import java.awt.print.PrinterIOException;
import java.util.PriorityQueue;

public class CourseSchedule3 {

    public int scheduleCourse(int[][] courses) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (p1, p2) -> p1.start - p2.start
        );
        for(int [] c : courses) {
            Pair pair = new Pair(c[1] - c[0], c[0]);
            pq.add(pair);
        }
        int temp = 1;
        int count = 0;
        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            if(pair.start <= temp) {
                temp += pair.duration;
                count++;
            }
        }
        return count;
     }

    static class Pair{
        int start;
        int duration;
        public Pair(int start, int duration) {
            this.start = start;
            this.duration = duration;
        }
    }
}
