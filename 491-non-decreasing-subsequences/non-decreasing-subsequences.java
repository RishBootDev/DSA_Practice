class Solution {
    
   private Set<List<Integer>> ans;
    public List<List<Integer>> findSubsequences(int[] nums) {
        ans = new HashSet<>();
        helper(nums, 0, new ArrayList<>());
        System.out.println(ans);
        return new ArrayList<>(ans);
    }
    public void helper(int nums[], int i, List<Integer> list) {
        if(list.size() < 2 && i == nums.length) return;
        if(list.size() >= 2 && i == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // list is empty
        if(list.isEmpty()) {
            // take
            list.add(nums[i]);
            helper(nums, i + 1, list);
            list.removeLast();

            // not take
            helper(nums, i + 1, list);
        }else {
            int last = list.getLast();
            if(nums[i] >= last) {
                // take
                list.add(nums[i]);
                helper(nums, i + 1, list);
                list.removeLast();

                // not take
                helper(nums, i + 1, list);
            }else {
                helper(nums, i + 1, list);
            }
        }
    }
}