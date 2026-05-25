public class GreatestSumDivisibleByThree {

    private int max = 0;
    public int maxSumDivThree(int[] nums) {
        helper(nums, 0, 0);
        return max;
    }

    public void helper(int[] nums, int i, int sum) {

        if(i == nums.length) {
            if(sum % 3 == 0) {
                max = Math.max(max, sum);
            }
            return;
        }
        // take
        helper(nums, i + 1, sum + nums[i]);
        // not take
        helper(nums, i + 1, sum);
    }
}