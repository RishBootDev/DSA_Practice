class Solution {
    
    public int sumDivisibleByK(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int c : nums) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int ans = 0;
        for(Map.Entry<Integer, Integer> ent : map.entrySet()) {
             int key = ent.getKey();
             int value = ent.getValue();
             if(value % k == 0) ans += key * value;
        }
        return ans;
    }
}