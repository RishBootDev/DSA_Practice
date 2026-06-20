import java.util.Collections;
import java.util.PriorityQueue;

public class Solution{

    public int minOperations(int[] nums1, int[] nums2) {

        int sum1 = 0;
        int sum2 = 0;

        for (int c : nums1) sum1 += c;
        for (int c : nums2) sum2 += c;

        if (sum1 == sum2) return 0;

        if (nums1.length * 6 < nums2.length ||
            nums2.length * 6 < nums1.length) {
            return -1;
        }

        PriorityQueue<Integer> pq1 =new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        int diff;

        if (sum1 > sum2) {

            diff = sum1 - sum2;
            for (int c : nums1) pq1.add(c);
            for (int c : nums2) pq2.add(c); 

        } else {

            diff = sum2 - sum1;
            for (int c : nums2) pq1.add(c); 
            for (int c : nums1) pq2.add(c); 
        }

        int op = 0;

        while (diff > 0 && (!pq1.isEmpty() || !pq2.isEmpty())) {

            int d1 = 0;
            int d2 = 0;

            if (!pq1.isEmpty()) {
                d1 = pq1.peek() - 1;
            }

            if (!pq2.isEmpty()) {
                d2 = 6 - pq2.peek();
            }

            int best = Math.max(d1, d2);
            if (best == 0) {
                return -1;
            }

            diff -= best;
            op++;

            if (d1 >= d2) {
                pq1.poll();
            } else {
                pq2.poll();
            }
        }
        return op;
    }
}