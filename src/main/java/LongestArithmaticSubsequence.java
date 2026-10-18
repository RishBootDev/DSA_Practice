public class LongestArithmaticSubsequence {

    public int longestArithSeqLength(int[] nums) {

        int max = 2;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = helper(nums, j + 1, j, nums[i] - nums[j]) + 2;
                max = Math.max(max, temp);
            }
        }
        return max;
    }

    public int helper(int [] arr, int i, int prev, int diff) {
        if (i == arr.length) return 0;

        if (arr[prev] - arr[i] == diff) {
            int take = helper(arr, i + 1, i, diff) + 1;
            int not = helper(arr, i + 1, prev, diff);
            return Math.max(take, not);
        }

        return helper(arr, i + 1, prev, diff);
    }
}
