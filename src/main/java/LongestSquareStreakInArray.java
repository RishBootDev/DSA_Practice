import java.util.Arrays;

public class LongestSquareStreakInArray {

    private int max = Integer.MIN_VALUE;

    public int longestSquareStreak(int[] nums) {

        Arrays.sort(nums);
        helper(nums, 0, -1, 0);
        if(max >= 2) return max;
        return -1;
    }

    public void helper(int nums[], int i, int prev, int count) {

        if(i == nums.length) {
            max = Math.max(max, count);
        }

        if(prev == -1) {
            // take
            helper(nums, i + 1, nums[i], count+1);
            // not take
            helper(nums, i + 1, prev, count);
        }
        else if(Math.sqrt(nums[i]) == (prev*1.0)) {
            // take
            helper(nums, i + 1, nums[i], count + 1);
            // not take
            helper(nums, i + 1, prev, count);
        }else {
            helper(nums, i + 1, prev, count);
        }
    }
}
