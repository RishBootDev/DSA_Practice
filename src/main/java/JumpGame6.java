public class JumpGame6 {

    // this is the accepted memoization and passed 58 test cases out of 73
    // but it gave me tle
    Integer dp[];
    public int maxResult(int[] nums, int k) {
        this.dp = new Integer[nums.length];
        return helper(nums,0 ,k) + nums[0];
    }
    public int helper(int nums[], int i, int k) {
        if(i == nums.length - 1) return 0;

        if(dp[i] != null) return dp[i];

        int score = Integer.MIN_VALUE;
        for (int j = i + 1; j < i + k; j++) {
           score = Math.max(score, helper(nums, j, k) + nums[j]);
        }
        return dp[i] = score;
    }
}
