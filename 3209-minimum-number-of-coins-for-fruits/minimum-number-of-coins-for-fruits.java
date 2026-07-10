class Solution {

    Integer dp[];

    public int minimumCoins(int[] prices) {
        dp = new Integer[prices.length];
        return helper(prices, 0);
    }

    public int helper(int[] prices, int i) {

        if (i >= prices.length) {
            return 0;
        }

        if(dp[i] != null) return dp[i];

        int ans = Integer.MAX_VALUE;
        for (int j = i + 1; j <= 2 * i + 2 && j <= prices.length; j++) {
            ans = Math.min(ans, helper(prices, j));
        }
        return dp[i] = prices[i] + ans;
    }
}