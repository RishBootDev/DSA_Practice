
import java.util.PriorityQueue;

public class IPO {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        // min heap based on the capital
        PriorityQueue<Pair> cap =
                new PriorityQueue<>((a, b) -> a.capital - b.capital);

        // Max heap based on profit
        PriorityQueue<Pair> prf =
                new PriorityQueue<>((a, b) -> b.profit - a.profit);

        for (int i = 0; i < profits.length; i++) {
            cap.add(new Pair(profits[i], capital[i]));
        }

        for (int i = 0; i < k; i++) {

            // add all affordable projects
            while (!cap.isEmpty()
                    && cap.peek().capital <= w) {

                prf.add(cap.poll());
            }

            // no project can be done
            if (prf.isEmpty()) {
                break;
            }

            // choose max profit project
            w += prf.poll().profit;
        }

        return w;
    }

    static class Pair {

        int profit;
        int capital;

        public Pair(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
}