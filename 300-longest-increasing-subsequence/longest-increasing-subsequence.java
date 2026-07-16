class Solution {

    int[][] dp;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(nums, 0, -1);
    }

    public int helper(int[] nums, int i, int prev) {
        if (i == nums.length) {
            return 0;
        }

        if (dp[i][prev + 1] != -1) {
            return dp[i][prev + 1];
        }

        if (prev == -1) {
            // take
            int take = helper(nums, i + 1, i) + 1;
            // not take
            int not = helper(nums, i + 1, -1);

            return dp[i][prev + 1] = Math.max(take, not);
        } else {
            if (nums[i] > nums[prev]) {
                // take
                int take = helper(nums, i + 1, i) + 1;
                // not take
                int not = helper(nums, i + 1, prev);
                return dp[i][prev + 1] = Math.max(take, not);
            }
            return dp[i][prev + 1] = helper(nums, i + 1, prev);
        }
    }
}