import java.util.Collections;
import java.util.PriorityQueue;

public class MaximalScoreAfterApplyingK {

    public long maxKelements(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int x : nums)  pq.add(x);

        int score = 0;
        while(k--> 0) {
            int temp = pq.poll();
            score += temp;
            pq.add(temp%3==0?temp/3: temp/3+1);
        }

        return score;
    }
}
