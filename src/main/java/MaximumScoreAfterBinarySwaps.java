import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumScoreAfterBinarySwaps {

    public long maximumScore(int[] nums, String s) {

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        long total=0;

        for(int i=0;i<nums.length;++i){
            pq.offer(nums[i]);

            if(s.charAt(i)=='1') {
                total +=pq.poll();
            }
        }

        return total;
    }
}
