class Solution {

    Integer dp[];
    
    public int rob(int[] nums) {
        dp = new Integer[nums.length];
        return helper(nums, 0);
    }
    public int helper(int[] nums, int i) {
        if(i >= nums.length) {
            return 0;
        }

        if(dp[i] != null) return dp[i];
        int take = helper(nums, i + 2) + nums[i];
        int not = helper(nums, i + 1);
        return dp[i] = Math.max(take, not);
    }
}