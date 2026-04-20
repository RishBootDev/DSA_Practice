import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {

    public int minIncrementForUnique(int[] nums) {

        Arrays.sort(nums);
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] <= nums[i - 1]) {
                int temp = nums[i];
                nums[i] = nums[i-1] + 1;
                count += (nums[i]- temp);
            }
        }
        return count;
    }
}
