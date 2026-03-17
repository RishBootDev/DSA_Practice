import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NMeetingsOneRoom {

    public int maxMeetings(int start[], int end[]) {

        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < start.length; i++) {
            pairs.add(new Pair(start[i], end[i]));
        }
        Collections.sort(pairs, (p1, p2) -> p1.end - p2.end);

        int count = 1; // first meeting always selected
        int last = pairs.get(0).end;

        for (int i = 1; i < pairs.size(); i++) {
            Pair pair = pairs.get(i);

            if (pair.start >= last) {
                count++;
                last = pair.end;
            }
        }

        return count;
    }

    static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}