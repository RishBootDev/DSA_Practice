import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumSumWithAtMostKelements {

    public long maxSum(int[][] grid, int[] limits, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int [] arr: grid) {
            Arrays.sort(arr);
            int set = k;
            int temp = arr.length -1;
            while(set-->0) {
                pq.add(arr[temp--]);
            }
        }

        long ans = 0;
        while(k-->0 && !pq.isEmpty()){
            ans+=pq.poll();
        }

        return ans;
    }
}
