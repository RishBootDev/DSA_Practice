class Solution {

    public int maxEqualAdjacentPairs(int[] nums) {

        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        String key = null;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] == nums[i + 1]) {
                count++;
                continue;
            }

            key = Math.max(nums[i], nums[i + 1]) + " "
                + Math.min(nums[i], nums[i + 1]);

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int max = 0;

        for (int c : map.values()) {
            max = Math.max(max, c);
        }

        return count + max;
    }
}