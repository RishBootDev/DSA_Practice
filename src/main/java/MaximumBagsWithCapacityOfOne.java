import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumBagsWithCapacityOfOne {

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        int count = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < capacity.length; i++) {
            if(capacity[i] - rocks[i] == 0) count++;
            else{
                list.add(capacity[i] - rocks[i]);
            }
        }

        Collections.sort(list);
        for(int x : list) {
            if(x > additionalRocks)
               break;
            additionalRocks-=x;
            count++;
        }

        return count;
    }
}
