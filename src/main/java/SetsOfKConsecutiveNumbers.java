import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetsOfKConsecutiveNumbers {

    public boolean isPossibleDivide(int[] nums, int k) {

        if (nums.length % k != 0) return false;

        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) continue;

            Set<Integer> set = new HashSet<>();
            set.add(nums[i]);
            used[i] = true;

            int prev = nums[i];
            int count = 1;

            for (int j = i + 1; j < nums.length && count < k; j++) {

                if (!used[j] && nums[j] == prev + 1) {
                    set.add(nums[j]);
                    used[j] = true;
                    prev = nums[j];
                    count++;
                }
            }

            if (count != k) return false;
        }

        return true;
    }
}
