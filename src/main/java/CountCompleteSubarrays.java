import java.util.HashSet;
import java.util.Set;

public class CountCompleteSubarrays {

    public int countCompleteSubarrays(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int c : nums) set.add(c);

        int count = 0;
        int n = nums.length;

        for (int l = set.size(); l <= nums.length; l++) {
            for (int i = 0; i <= n - l; i++) {

                Set<Integer> temp = new HashSet<>();
                for (int j = i; j < i + l; j++) {
                    temp.add(nums[j]);
                }

                if (set.size() == temp.size()) count++;
            }
        }

        return count;
    }
}