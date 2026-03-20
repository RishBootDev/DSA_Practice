import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TheNumberOfSmallestUnoccupiedChairs {

    public int smallestChair(int[][] times, int targetFriend) {

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < times.length; i++) {
            Pair pair = new Pair(times[i][0], times[i][1], i);
            pairs.add(pair);
        }

        Collections.sort(pairs, (p1, p2) -> p1.st - p2.st);

        int tracked[] = new int[times.length];
        int leaveTime[] = new int[times.length];

        Arrays.fill(tracked, -1);

        for (int i = 0; i < pairs.size(); i++) {

            Pair pair = pairs.get(i);

            for (int j = 0; j < tracked.length; j++) {
                if (tracked[j] != -1 && leaveTime[j] <= pair.st) {
                    tracked[j] = -1;
                }
            }

            int chair = -1;
            for (int j = 0; j < tracked.length; j++) {
                if (tracked[j] == -1) {
                    chair = j;
                    break;
                }
            }

            tracked[chair] = pair.friend;
            leaveTime[chair] = pair.ent;

            if (pair.friend == targetFriend) {
                return chair;
            }
        }

        return -1;
    }

    static class Pair {
        int st;
        int ent;
        int friend;

        public Pair(int st, int ent, int friend) {
            this.st = st;
            this.ent = ent;
            this.friend = friend;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "st=" + st +
                    ", ent=" + ent +
                    ", friend=" + friend +
                    '}';
        }
    }
}