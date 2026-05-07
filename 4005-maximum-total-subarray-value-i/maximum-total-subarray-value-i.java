class Solution {
    public long maxTotalValue(int[] nums, int k) {
        
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        for(int c : nums) {
            max = Math.max(c, max);
            min = Math.min(c, min);
        }
        return (max - min) * k;
    }
}