class Solution {

    public int longestSquareStreak(int[] nums) {

        Arrays.sort(nums);

        Map<Integer, Integer> dp = new HashMap<>();

        int max = 0;

        for (int num : nums) {

            int root = (int) Math.sqrt(num);

            if (root * root == num && dp.containsKey(root)) {
                dp.put(num, dp.get(root) + 1);
            } else {
                dp.put(num, 1);
            }

            max = Math.max(max, dp.get(num));
        }

        return max >= 2 ? max : -1;
    }
}