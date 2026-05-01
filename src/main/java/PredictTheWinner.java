public class PredictTheWinner {

    private boolean dp[][][];
    public boolean predictTheWinner(int[] nums) {
        dp = new boolean[nums.length][nums.length][2];
        return helper(nums, 0, 0, 0, nums.length - 1, true);
    }

    public boolean helper(int[] nums, int a, int b,
                          int i, int j, boolean flag) {

        if (i > j) {
            return a >= b;
        }
        int turn = flag ? 1 : 0;

        if(dp[i][j][turn]) return true;
        if (flag) {
            boolean takeFirst = helper(nums, a + nums[i], b,i + 1, j, false);
            boolean takeLast =helper(nums, a + nums[j], b,i, j - 1, false);
            return dp[i][j][turn] = takeFirst || takeLast;
        } else {
            boolean takeFirst = helper(nums, a, b + nums[i],i + 1, j, true);
            boolean takeLast =helper(nums, a, b + nums[j], i, j - 1, true);
            return dp[i][j][turn] = takeFirst && takeLast;
        }
    }
}
