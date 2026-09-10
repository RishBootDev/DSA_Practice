public class MaximumLengthOfValidSubsequence {

    Integer dp [][][];
    public int maximumLength(int[] nums) {
        dp = new Integer[nums.length][nums.length + 1][nums.length + 1];
        return helper(nums, 0, -1, -1);
    }
    public int helper(int nums[], int i, int prev, int target) {
        if(i == nums.length) {
            return 0;
        }
        if(dp[i][prev + 1][target + 1] != null) return dp[i][prev + 1][target + 1];
        if(prev == -1) {
            // take
            int take = helper(nums, i + 1, i, -1) + 1;
            // not
            int not = helper(nums, i + 1, prev, -1);
            return dp[i][prev + 1][target + 1] = Math.max(take, not);
        }else {
            if(target == -1) {
                // take
                int take = helper(nums, i + 1, i, (nums[i] + nums[prev])%2) + 1;
                // not
                int not = helper(nums, i + 1, prev, -1);
                return dp[i][prev + 1][target + 1] = Math.max(take, not);
            }else {
                if ((nums[i] + nums[prev]) % 2 == target) {
                    // take
                    int take = helper(nums, i + 1, i, target) + 1;
                    // not
                    int not = helper(nums, i + 1, prev, target);
                    return dp[i][prev + 1][target + 1] = Math.max(take, not);
                }else {
                    return dp[i][prev + 1][target + 1] = helper(nums, i + 1, prev, target);
                }
            }
        }
    }
}
