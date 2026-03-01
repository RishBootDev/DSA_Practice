import java.util.Collections;
import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTotal {

    public int minStoneSum(int[] piles, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int x : piles){
            pq.add(x);
        }

        while(k-- > 0){
            int temp = pq.poll();
            pq.add(temp - temp / 2);
        }

        int sum = 0;
        while(!pq.isEmpty()) sum += pq.poll();

        return sum;
    }
}
