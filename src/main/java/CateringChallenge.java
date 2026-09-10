import java.util.PriorityQueue;
import java.util.Scanner;

public class CateringChallenge {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int d = sc.nextInt();

            PriorityQueue<Order> arrival = new PriorityQueue<>(
                    (p1, p2) -> p1.start - p2.start
            );

            PriorityQueue<Order> pq = new PriorityQueue<>(
                    (p1, p2) -> p2.penalty - p1.penalty
            );

            for (int i = 0; i < n; i++) {
                int di = sc.nextInt();
                int ti = sc.nextInt();
                int si = sc.nextInt();
                arrival.add(new Order(di, ti, si));
            }

            for (int day = 1; day <= d; day++) {

                while (!arrival.isEmpty() && arrival.peek().start == day) {
                    pq.add(arrival.poll());
                }
                if (!pq.isEmpty()) {
                    Order order = pq.poll();
                    order.days--;
                    if (order.days > 0) {
                        pq.add(order);
                    }
                }
            }

            long count = 0;

            while (!pq.isEmpty()) {
                Order order = pq.poll();
                count += (long) order.days * order.penalty;
            }

            while (!arrival.isEmpty()) {
                Order order = arrival.poll();
                count += (long) order.days * order.penalty;
            }
            System.out.println(count);
        }
    }

    static class Order{
        int start;
        int days;
        int penalty;

        public Order(int start, int days, int penalty) {
            this.start = start;
            this.days = days;
            this.penalty = penalty;
        }
    }
}
