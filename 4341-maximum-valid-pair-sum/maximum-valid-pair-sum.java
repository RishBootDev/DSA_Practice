class Solution {
    
    public int maxValidPairSum(int[] nums, int k) {

        int suff[] = new int[nums.length];
        int max = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0 ; i--) {
            max = Math.max(nums[i], max);
            suff[i] = max;
        }
        
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(i + k < nums.length) {
                int temp = nums[i] + suff[i + k];
                ans = Math.max(temp, ans);
            }
        }
        return ans;
    }
}