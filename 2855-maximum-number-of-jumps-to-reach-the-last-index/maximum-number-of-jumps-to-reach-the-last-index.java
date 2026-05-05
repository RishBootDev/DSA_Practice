public class Solution {

    Integer dp[];

    public int maximumJumps(int[] nums, int target) {

        this.dp = new Integer[nums.length];
        int ans = helper(nums, 0, target);
        return ans < 0 ? -1 : ans;
    }

    public int helper(int[] nums, int i, int target) {

        if (i == nums.length - 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;

        if(dp[i] != null) return dp[i];

        for (int j = i + 1; j < nums.length; j++) {
            if (Math.abs(nums[j] - nums[i]) <= target) {
                int next = helper(nums, j, target);
                if (next != -1) {
                    max = Math.max(max, 1 + next);
                }
            }
        }
        return dp[i] = max == Integer.MIN_VALUE ? -1 : max;
    }
}