class Solution {
    public long maxArrayValue(int[] nums) {
        if (nums.length == 1) return nums[0];

        long max = nums[nums.length - 1];
        long curr = nums[nums.length - 1];

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] <= curr) {
                curr += nums[i - 1];
                max = Math.max(max, curr);
            } else {
                curr = nums[i - 1];
                max = Math.max(max, curr);
            }
        }

        return max;
    }
}