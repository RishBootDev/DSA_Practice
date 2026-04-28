import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PutMarblesInBag {

    public long putMarbles(int[] weights, int k) {

        List<Integer> sum = new ArrayList<>();

        for (int i = 0; i < weights.length -1; i++) {
            int temp = weights[i] + weights[i+1];
            sum.add(temp);
        }

        Collections.sort(sum);
        int temp = k-1;
        long min = 0;
        int i = 0;
        while(temp --> 0) min += sum.get(i++);
        long max = 0;
        i = sum.size() - 1;
        k--;
        while(k--> 0) max += sum.get(i--);

        return max - min;
    }
}
