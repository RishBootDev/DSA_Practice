public class PartitionEqualSubsetSum {


    // this is the working recursion code for and correctly handles 90 percent of the test
    // cases but it is not optimized and to furthur optimize it we will use dynamic programming
    // approach
    public boolean canPartition(int[] nums) {

        return helper(nums, 0, 0, 0);

    }
    public boolean helper(int nums[], int i, int x , int y) {

        if(i == nums.length) {
            if(x == y) return true;
            return false;
        }

        boolean xtake = helper(nums, i + 1, x + nums[i], y);
        boolean ytake = helper(nums, i + 1, x, y + nums[i]);

        return xtake || ytake;
    }



    // this is the correct optimized solution for the subarray sum
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;

        Boolean[][] dp = new Boolean[nums.length][sum + 1];

        return helper2(nums, 0, 0, sum, dp);
    }

    public boolean helper2(int[] nums, int i, int x, int total, Boolean[][] dp) {

        if (i == nums.length) {
            return x == total - x;
        }

        if (dp[i][x] != null) return dp[i][x];

        boolean xtake = helper2(nums, i + 1, x + nums[i], total, dp);
        boolean ytake = helper2(nums, i + 1, x, total, dp);

        return dp[i][x] = xtake || ytake;
    }
}
