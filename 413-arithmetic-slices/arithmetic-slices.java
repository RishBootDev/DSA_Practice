class Solution {
   
   int ans = 0;
   Integer dp [];
    public int numberOfArithmeticSlices(int[] nums) {
        this.dp = new Integer[nums.length];
        helper(nums, nums.length - 1);
        return ans;
    }
    public int helper(int nums[], int i) {
        if(i < 2) return 0;

        if(dp[i] != null) return dp[i];

        int prev = helper(nums, i - 1);
        if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
            ans += prev + 1;
            return dp[i] = prev + 1;
        }
        return dp[i] = 0;
    }
}