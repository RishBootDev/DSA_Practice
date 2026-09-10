class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int c : nums) set.add(c);
        int temp = k;
        for(int i = 0; i< nums.length; i++) {

            if(!set.contains(temp)) {
                return temp; 
            }
            temp += k;
        }
        return temp;
    }
}