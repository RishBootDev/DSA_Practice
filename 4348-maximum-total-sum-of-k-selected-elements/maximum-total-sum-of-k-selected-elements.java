class Solution {

    public long maxSum(int[] nums, int k, int mul) {

        long ans = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= (nums.length - k); i--) {
            if (mul > 0) {
                ans += ((long) mul * nums[i]);
                mul--;
            } else {
                ans += nums[i];
            }
        }
        return ans;

    }
}