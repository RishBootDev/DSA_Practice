import java.util.PriorityQueue;

public class MinimumCostToHireWorkersProblem {

    private String difficulty="Hard";

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(a.expectedWage / a.quality, b.expectedWage / b.quality)
        );

        for (int i = 0; i < quality.length; i++) {
            pq.add(new Pair(quality[i], wage[i]));
        }

        PriorityQueue<Double> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b, a));

        double qualitySum = 0;
        double minCost = Double.MAX_VALUE;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            qualitySum += p.quality;
            maxHeap.add(p.quality);

            if (maxHeap.size() > k) {
                qualitySum -= maxHeap.poll();
            }

            if (maxHeap.size() == k) {
                double ratio = p.expectedWage / p.quality;
                double cost = qualitySum * ratio;
                minCost = Math.min(minCost, cost);
            }
        }

        return minCost;
    }

    static class Pair {
        double quality;
        double expectedWage;

        public Pair(int quality, int expectedWage) {
            this.quality = quality;
            this.expectedWage = expectedWage;
        }
    }
}
