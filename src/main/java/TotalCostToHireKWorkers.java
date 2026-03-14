
import java.util.PriorityQueue;

public class TotalCostToHireKWorkers {

    public long totalCost(int[] costs, int k, int candidates) {

        PriorityQueue<Pair> start = new PriorityQueue<>((p1, p2) -> p1.a - p2.a);
        PriorityQueue<Pair> end = new PriorityQueue<>((p1, p2) -> p1.a - p2.a);

        int n = costs.length;

        int left = 0;
        int right = n - 1;

        for (int i = 0; i < candidates && left <= right; i++) {
            start.add(new Pair(costs[left], left));
            left++;
        }

        for (int i = 0; i < candidates && left <= right; i++) {
            end.add(new Pair(costs[right], right));
            right--;
        }

        long ans = 0;

        while (k-- > 0) {

            if (end.isEmpty() || (!start.isEmpty() && start.peek().a <= end.peek().a)) {

                Pair p = start.poll();
                ans += p.a;
                if (left <= right) {
                    start.add(new Pair(costs[left], left));
                    left++;
                }
            } else {
                Pair p = end.poll();
                ans += p.a;
                if (left <= right) {
                    end.add(new Pair(costs[right], right));
                    right--;
                }
            }
        }
        return ans;
    }

    static class Pair {
        int a;
        int idx;

        Pair(int a, int idx) {
            this.a = a;
            this.idx = idx;
        }
    }
}
