import java.util.Arrays;

public class MaximumGreatNessOfArray {

    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);

        int i = 0;
        int j = 0;

        int count = 0;

        while (j < nums.length) {
            if (nums[j] > nums[i]) {
                count++;
                i++;
            }
            j++;
        }

        return count;
    }
}
