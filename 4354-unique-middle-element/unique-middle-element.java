class Solution {
    public boolean isMiddleElementUnique(int[] nums) {

        int mid = nums.length/2;
        if(nums.length == 1) return true;
        
        int count = 0;
        for(int c : nums) {
            if(c == nums[mid]) count++;
        }
        
        if(count > 1) return false;
        return true;
    }
}