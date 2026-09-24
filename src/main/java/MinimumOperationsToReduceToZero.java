public class MinimumOperationsToReduceToZero {

    Integer dp[][];
    public int minOperations(int[] nums, int x) {
        this.dp = new Integer[nums.length][nums.length];
        int ans = helper(nums, 0, nums.length - 1, x);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int helper(int[] nums, int left, int right, int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 0 || left > right) {
            return Integer.MAX_VALUE;
        }

        if(dp[left][right] != null) return dp[left][right];
        int l = helper(nums, left + 1, right, x - nums[left]);
        int r = helper(nums, left, right - 1, x - nums[right]);

        if (l != Integer.MAX_VALUE) {
            l++;
        }
        if (r != Integer.MAX_VALUE) {
            r++;
        }
        return dp[left][right] = Math.min(l, r);
    }
}
