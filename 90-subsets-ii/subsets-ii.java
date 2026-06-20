class Solution {
    
     public List<List<Integer>> subsetsWithDup(int[] nums) {

           Arrays.sort(nums);
           Set<List<Integer>> set = new HashSet<>();
           helper(nums, 0, new ArrayList<>(), set);
           return new ArrayList<>(set);
    }

    public void helper(int nums[], int i, List<Integer> list,     Set<List<Integer>> set) {
        if(i == nums.length) {
            set.add(new ArrayList<>(list));
            return;
        }
        
        // take
        list.add(nums[i]);
        helper(nums, i + 1, list, set);
        list.removeLast();
        
        // not take
        helper(nums, i + 1, list, set);
    }

}