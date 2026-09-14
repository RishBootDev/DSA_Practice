public class JumpGame6 {

    // this is the accepted recursion and passed 5 test cases out of 73
    // but it game me tle let us memoize it
    public int maxResult(int[] nums, int k) {
        return helper(nums,0 ,k) + nums[0];
    }
    public int helper(int nums[], int i, int k) {
        if(i == nums.length - 1) return 0;

        int score = Integer.MIN_VALUE;
        for (int j = i + 1; j < i + k; j++) {
           score = Math.max(score, helper(nums, j, k) + nums[j]);
        }
        return score;
    }
}
