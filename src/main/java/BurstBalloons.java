public class BurstBalloons {

    public int maxCoins(int[] nums) {
       return helper(nums, -1, 0, 1);
    }

    public int helper(int nums[], int j , int i, int k) {
        if(i == nums.length) return 0;

        int left = j >= 0? nums[j] : 1;
        int right = k < nums.length ? nums[k] : 1;

        // take
        int take = (left * nums[i] * right) +
                helper(nums, j, k, k + 1);
        // not take
        int not = helper(nums, i, i + 1, k + 1);

        return Math.max(take, not);
    }
}
