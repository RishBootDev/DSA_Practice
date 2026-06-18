class Solution {
    
    public int maxDistinctElements(int[] nums, int k) {

        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[0] - k);

        for (int i = 1; i < nums.length; i++) {
            int temp = ans.getLast();
            int diff = nums[i] - k;
            if(diff > temp) {
                ans.add(diff);
            }else {
                if(temp + 1 <= nums[i] + k)
                   ans.add(temp + 1);
                
            }
        }
        System.out.println(ans);
        Set<Integer> set = new HashSet<>(ans);
        return set.size();
    }
}