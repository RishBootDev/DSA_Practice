class Solution {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        offers.sort((l1, l2) -> l1.get(0) - l2.get(0));

        int m = offers.size();
        int[] dp = new int[m];

        Arrays.fill(dp, -1);

        return helper(0, offers, dp);
    }

    public int helper(int i, List<List<Integer>> offers, int[] dp) {
        if (i == offers.size()) return 0;

        if (dp[i] != -1) return dp[i];

        List<Integer> curr = offers.get(i);

        int start = curr.get(0);
        int end = curr.get(1);
        int profit = curr.get(2);

        int next = findNext(offers, end);

        int take = profit + helper(next, offers, dp);
        int not = helper(i + 1, offers, dp);

        return dp[i] = Math.max(take, not);
    }

    public int findNext(List<List<Integer>> offers, int end) {
        int low = 0;
        int high = offers.size() - 1;
        int ans = offers.size();

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (offers.get(mid).get(0) > end) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}