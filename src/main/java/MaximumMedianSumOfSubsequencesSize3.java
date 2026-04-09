import java.util.Arrays;

public class MaximumMedianSumOfSubsequencesSize3 {

    public long maximumMedianSum(int[] nums) {

        Arrays.sort(nums);
        int ans = 0;
        int i = 0;
        int j = nums.length - 2;

        while (i < j) {
            ans += nums[j];
            i++;
            j-=2;
        }
        return ans;

    }
}
