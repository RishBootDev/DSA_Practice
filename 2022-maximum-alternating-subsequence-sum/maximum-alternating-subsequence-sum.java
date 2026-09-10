class Solution {

    Long[][] dp;

    public long maxAlternatingSum(int[] nums) {
        dp = new Long[nums.length][2];
        return helper(nums, 0, 0);
    }

    public long helper(int[] nums, int i, int state) {
        if(i == nums.length) {
            return 0;
        }

        if(dp[i][state] != null) {
            return dp[i][state];
        }

        // not take
        long notTake = helper(nums, i + 1, state);

        long take;

        if(state == 0) {
            // take
            take = nums[i] + helper(nums, i + 1, 1);
        } else {
            // take
            take = -nums[i] + helper(nums, i + 1, 0);
        }

        return dp[i][state] = Math.max(take, notTake);
    }
}