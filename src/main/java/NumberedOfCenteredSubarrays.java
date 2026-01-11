import java.util.HashSet;
import java.util.Set;

public class NumberedOfCenteredSubarrays {


    // this solution is accepted but the time complexity of O(n3)
    public int centeredSubarrays(int[] nums) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length ; j++) {
                Set<Integer> set = new HashSet<>();

                int sum = 0;
                for (int k = i; k <= j; k++) {
                    set.add(nums[k]);
                    sum+=nums[k];
                }

                if(set.contains(sum)) count++;
            }
        }

        return count;
    }

    // this is the optimized version of the above code with complexity of O(n2)
    public int centeredSubarraysOptimized(int[] nums) {

        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {

            int sum = 0;
            Set<Integer> set = new HashSet<>();

            for (int j = i; j < n; j++) {
                sum += nums[j];
                set.add(nums[j]);

                if (set.contains(sum)) {
                    count++;
                }
            }
        }

        return count;
    }
}
