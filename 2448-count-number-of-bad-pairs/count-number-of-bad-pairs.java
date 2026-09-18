class Solution {
    
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        long good = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int target = i - nums[i];
            if(map.containsKey(target)) {
                good += map.get(target);
            }
            map.put(target, map.getOrDefault(target, 0) + 1);
        }

        long total = (long)n * (n - 1) / 2;
        return total - good;
    }
}