import java.util.Collections;
import java.util.PriorityQueue;

public class MaximizeHappiness {

    public long maximumHappinessSum(int[] happiness, int k) {

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int c: happiness) pq.add(c);

        int temp=0;
        long ans=0;
        while(k-->0){

            int get=pq.poll()-temp;
            if(get<0) get=0;

            ans+=get;
            temp++;
        }

        return ans;
    }
}
