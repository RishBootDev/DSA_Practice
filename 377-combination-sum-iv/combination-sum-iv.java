class Solution {
    int[] dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return helper(nums, target);
    }

    public int helper(int[] arr, int target) {
        if (target == 0)
            return 1;

        if (target < 0)
            return 0;

        if (dp[target] != -1)
            return dp[target];
        int ans = 0;
        for (int num : arr) {
            ans += helper(arr, target - num);
        }
        return dp[target] = ans;
    }
}