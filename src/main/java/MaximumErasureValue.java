import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {

    public int maximumUniqueSubarray(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int ans = 0;
        int max = Integer.MIN_VALUE;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {

            while(set.contains(nums[right])) {
                set.remove(nums[left]);
                ans -= nums[left];
                left++;
            }

            set.add(nums[right]);
            ans += nums[right];

            max = Math.max(ans, max);

        }
        return max;
    }
}
