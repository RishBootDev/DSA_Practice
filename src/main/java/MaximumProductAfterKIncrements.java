import java.util.PriorityQueue;

public class MaximumProductAfterKIncrements {

    public int maximumProduct(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int c : nums) pq.add(c);

        while(k --> 0 && !pq.isEmpty()) {
            int temp = pq.poll();
            pq.add(temp + 1);
        }

        int prod = 1;
        for(int c : pq) prod *= c;
        return prod;
    }
}
