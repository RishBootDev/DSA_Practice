class Solution {

    Integer[][] dp;

    public int minimumOperations(List<Integer> nums) {
        dp = new Integer[nums.size()][nums.size() + 1];

        int max = helper(nums, 0, -1);
        return nums.size() - max;
    }

    public int helper(List<Integer> list, int i, int prev) {
        if (i == list.size()) {
            return 0;
        }

        if (dp[i][prev + 1] != null) {
            return dp[i][prev + 1];
        }

        int take = 0;
        if (prev == -1) {

            // take
            take = 1 + helper(list, i + 1, i);
            // not take
            int notTake = helper(list, i + 1, -1);

            return dp[i][prev + 1] = Math.max(take, notTake);

        } else {

            if (list.get(i) >= list.get(prev)) {
                // take
                take = 1 + helper(list, i + 1, i);
            }
            // not take
            int notTake = helper(list, i + 1, prev);

            return dp[i][prev + 1] = Math.max(take, notTake);
        }
    }
}