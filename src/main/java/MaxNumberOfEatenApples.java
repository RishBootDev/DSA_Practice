import java.util.PriorityQueue;

class MaxNumberOfEatenApples{

    static class Pair {
        int a;
        int day;

        public Pair(int a, int day) {
            this.a = a;
            this.day = day;
        }
    }

    public int eatenApples(int[] apples, int[] days) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.day - p2.day);

        int count = 0;
        int day = 0;
        int n = apples.length;

        while (day < n || !pq.isEmpty()) {

            if (day < n && apples[day] > 0) {
                pq.add(new Pair(apples[day], day + days[day]));
            }

            while (!pq.isEmpty() && pq.peek().day <= day) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                Pair current = pq.poll();
                current.a--;
                count++;

                if (current.a > 0) {
                    pq.add(current);
                }
            }

            day++;
        }

        return count;
    }
}