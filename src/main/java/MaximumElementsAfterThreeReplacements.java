import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumElementsAfterThreeReplacements {

    public long maxProduct(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int c : nums) list.add(c);

        Collections.sort(list, (a,b)->Math.abs(a)- Math.abs(b));

        int prod = list.get(0)*list.get(1);
        if(prod < 0) return prod * 100000L;
        return  prod * -100000L;

    }
}
