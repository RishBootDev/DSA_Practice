class Solution {

        Integer[][] dp;

    
    public int maxOperations(int[] nums) {

         dp = new Integer[nums.length][nums.length];

        int a = 1 + helper(nums, 2, nums.length - 1, nums[0] + nums[1]);
        int b = 1 + helper(nums, 0, nums.length - 3, nums[nums.length - 1] + nums[nums.length - 2]);
        int c = 1 + helper(nums, 1, nums.length - 2, nums[0]+nums[nums.length - 1]);
        
        return Math.max(a, Math.max(b, c));
    }

   public int helper(int nums[], int i, int j, int score) {

        if (i >= j) return 0;

        if (dp[i][j] != null) return dp[i][j];


        int max = 0;

        int diff1 = nums[i] + nums[i + 1];
        int diff2 = nums[j] + nums[j - 1];
        int diff3 = nums[i] + nums[j];

        if (diff1 == score) {
            max = Math.max(max,1 + helper(nums, i + 2, j, score));
        }

        if (diff2 == score) {
            max = Math.max(max,1 + helper(nums, i, j - 2, score));
        }

        if (diff3 == score) {
            max = Math.max(max,1 + helper(nums, i + 1, j - 1, score));
        }

        return dp[i][j] =max;
    }
}