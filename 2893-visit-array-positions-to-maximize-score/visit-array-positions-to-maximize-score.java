class Solution {
    public long maxScore(int[] nums, int x) {
        long even;
        long odd;
        if (nums[0] % 2 == 0){
            even = nums[0];
            odd = nums[0]-x;
        } else {
            even = nums[0]-x;
            odd = nums[0];
        }
        for (int i = 1; i < nums.length; i++){
            if (nums[i] % 2 == 0){
                even += nums[i];
                even = Math.max(even, odd + nums[i] - x);
            } else {
                odd += nums[i];
                odd = Math.max(odd, even + nums[i] - x);
            }
        }
        return Math.max(odd, even);
    }
}