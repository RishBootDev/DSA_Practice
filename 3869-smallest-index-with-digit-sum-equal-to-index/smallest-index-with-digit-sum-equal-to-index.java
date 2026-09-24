class Solution {
    

    public int smallestIndex(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if(sum(nums[i]) == i) return i;
        }
        return -1;
        
    }
    public int sum(int c) {
        String temp = String.valueOf(c);

        int ans = 0;
        for (int i = 0; i < temp.length(); i++) {
            ans += temp.charAt(i) - '0';
        }
        return ans;
    }
}