import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayOfDoubledPair {
    public boolean canReorderDoubled(int[] arr) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(!set.contains(2 * arr[i])) count++;
            else count--;
        }

        return count == 0;
    }
}
