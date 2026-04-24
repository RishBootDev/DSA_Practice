import java.util.Collections;
import java.util.PriorityQueue;

public class KthNearestQueries {

    public int[] resultsArray(int[][] queries, int k) {

        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        int ans [] = new int[queries.length];
        int j = 0;

        for(int [] q : queries) {
            int x = q[0];
            int y = q[1];
            pq.add(Math.abs(x) + Math.abs(y));
            int temp = -1;
            while(k-->0 && !pq.isEmpty()) {
                temp = pq.poll();
            }
            ans[j++] = temp;
        }

        return ans;
    }
}
