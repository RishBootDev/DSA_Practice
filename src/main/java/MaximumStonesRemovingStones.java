import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumStonesRemovingStones {

    public int maximumScore(int a, int b, int c) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.add(a);
        pq.add(b);
        pq.add(c);
        int count = 0;
        while(pq.peek() != 0){
            int num1 = pq.poll();
            int num2 = pq.poll();

            if(num1 == 0 || num2 == 0) return count;

            num1--;
            num2--;
            pq.add(num1);
            pq.add(num2);
        }

        return count;
    }
}
