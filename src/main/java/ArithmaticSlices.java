public class ArithmaticSlices {

    int ans = 0;
    public int numberOfArithmeticSlices(int[] nums) {

        helper(nums, nums.length - 1);
        return ans;
    }
    public int helper(int nums[], int i) {
        if(i < 2) return 0;

        int prev = helper(nums, i - 1);
        if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
            ans += prev + 1;
            return prev + 1;
        }
        return 0;
    }
}
