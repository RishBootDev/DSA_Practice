public class MaximumNumberOfOperationsWithSameScore {

    public int maxOperations(int[] nums) {

        int a = 1 + helper(nums, 2, nums.length - 1, nums[0] + nums[1]);
        int b = 1 + helper(nums, 0, nums.length - 3, nums[nums.length - 1] + nums[nums.length - 2]);
        int c = 1 + helper(nums, 1, nums.length - 2, nums[0]+nums[nums.length - 1]);

        return Math.max(a, Math.max(b, c));
    }

    public int helper(int nums[], int i , int j, int score) {
        if(i >= j) return 1;

        int diff1 = nums[i] + nums[i + 1];
        int diff2 = nums[j] + nums[j - 1];
        int diff3 = nums[i] + nums[j];

        if(diff1 == score) {
            return 1 + helper(nums, i + 2, j, diff1);
        }else if (diff2 == score) {
            return 1 + helper(nums, i, j - 2, diff2);
        }else return 1 + helper(nums, i + 1, j - 1, diff3);
    }
}
