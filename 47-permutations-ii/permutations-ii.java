class Solution {
    
    public List<List<Integer>> permuteUnique(int[] nums) {

        boolean [] used = new boolean[nums.length];
        Set<List<Integer>> set = new HashSet<>();
        
        helper(nums, used, new ArrayList<>(), set);
        return new ArrayList<>(set);
    }
    public void helper(int [] nums, boolean [] used, List<Integer> temp,
                       Set<List<Integer>> set) {

        if(temp.size() == nums.length) {
            set.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }
            used[i] = true;
            temp.add(nums[i]);
            
            helper(nums, used, temp, set);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}