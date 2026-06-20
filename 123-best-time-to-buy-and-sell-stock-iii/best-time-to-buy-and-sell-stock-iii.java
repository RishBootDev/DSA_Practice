class Solution {

    Integer dp[][][];

    public int maxProfit(int[] prices) {

        int n = prices.length;
        dp = new Integer[n][2][3];

        return helper(0, 1, 2, prices);
    }

    public int helper(int i, int buy, int cap, int[] prices) {

        if (i == prices.length || cap == 0)
            return 0;

        if (dp[i][buy][cap] != null)
            return dp[i][buy][cap];

        if (buy == 1) {

            // Buy or skip
            int take = -prices[i] + helper(i + 1, 0, cap, prices);

            int not = helper(i + 1, 1, cap, prices);
            return dp[i][buy][cap] = Math.max(take, not);

        } else {

            // Sell or hold
            int sell = prices[i] + helper(i + 1, 1, cap - 1, prices);
            int not = helper(i + 1, 0, cap, prices);

            return dp[i][buy][cap] = Math.max(sell, not);
        }
    }
}