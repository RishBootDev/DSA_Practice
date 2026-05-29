class Solution {
    public long rob(int[] nums, int[] colors) {
        int n = nums.length;

        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; --i) {
            boolean canrob_both = (i + 1 == n || colors[i] != colors[i + 1]);
            if (canrob_both) 
                dp[i] = nums[i] + dp[i + 1];
            else 
                dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }

        return dp[0];
    }
}