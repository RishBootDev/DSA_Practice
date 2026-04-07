import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RearrangeArrayToMaximizeProfit {

    public int maxScore(int[] arr) {

        List<Integer> list = new ArrayList<>();
        for(int c : arr) list.add(c);
        Collections.sort(list, Collections.reverseOrder());

        long pre[] = new long[arr.length];
        long sum = 0;

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
            pre[i] = sum;
        }

        int count = 0;
        for(long c : pre) {
            if(c > 0) count++;
        }

        return count;

    }
}
