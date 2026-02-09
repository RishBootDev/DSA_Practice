import java.util.HashSet;
import java.util.Set;

public class CountNumberOFDistinctIntegers {

    public int countDistinctIntegers(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            int rev = Integer.parseInt(
                    new StringBuilder(String.valueOf(nums[i]))
                            .reverse()
                            .toString());

            set.add(rev);
            set.add(nums[i]);
        }

        return set.size();
    }
}
