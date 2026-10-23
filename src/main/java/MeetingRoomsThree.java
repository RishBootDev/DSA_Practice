import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MeetingRoomsThree {

        public int mostBooked(int n, int[][] meetings) {

            Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

            PriorityQueue<Pair> pq = new PriorityQueue<>(
                    (p1, p2) -> Integer.compare(p1.start, p2.start)
            );

            for (int meeting[] : meetings) {
                Pair pair = new Pair(meeting[0], meeting[1]);
                pq.add(pair);
            }

            PriorityQueue<Pair> minq = new PriorityQueue<>(
                    (p1, p2) -> {
                        if (p1.end != p2.end)
                            return Integer.compare(p1.end, p2.end);
                        return Integer.compare(p1.room, p2.room);
                    }
            );

            Map<Integer, Integer> map = new HashMap<>();

            PriorityQueue<Integer> rooms = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                rooms.add(i);
            }

            while (!pq.isEmpty()) {
                Pair pair = pq.poll();

                while (!minq.isEmpty() && minq.peek().end <= pair.start) {
                    rooms.add(minq.poll().room);
                }

                if (!rooms.isEmpty()) {
                    pair.room = rooms.poll();
                } else {
                    Pair min = minq.poll();

                    int duration = pair.end - pair.start;
                    pair.start = min.end;
                    pair.end = pair.start + duration;
                    pair.room = min.room;
                }

                map.put(pair.room, map.getOrDefault(pair.room, 0) + 1);
                minq.add(pair);
            }

            int ans = 0;
            int tp = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                int count = map.getOrDefault(i, 0);

                if (count > tp) {
                    ans = i;
                    tp = count;
                }
            }

            return ans;
        }

        static class Pair {
            int start;
            int end;
            int room;

            public Pair(int start, int end) {
                this.start = start;
                this.end = end;
                this.room = -1;
            }
        }

}
