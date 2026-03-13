import java.util.Collections;
import java.util.List;

public class EqualGreedy {

    public static int equal(List<Integer> arr) {
        int min = Collections.min(arr);

        int result = Integer.MAX_VALUE;
        for (int base = 0; base < 5; base++) {
            int operations = 0;
            int target = min - base;
            for (int val : arr) {
                int diff = val - target;
                operations += diff / 5; diff %= 5;
                operations += diff / 2; diff %= 2;
                operations += diff;
            }
            result = Math.min(result, operations);
        }
        return result;

    }
}
