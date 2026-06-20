class Solution {

    Integer dp[][];
    
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][prices.length + 1];
        return helper(0, -1, prices);
    }
    public int helper(int i, int prev, int prices[]) {
        if(i >= prices.length) {
            return 0;
        }

        if(dp[i][prev+1] != null) return dp[i][prev + 1];
        // if not purchased any
        if(prev == -1) {
            int take = helper(i + 1, i, prices);
            int not = helper(i + 1, prev, prices);
            return dp[i][prev + 1] = Math.max(take, not);
        }else{
            // can purchase
            int sold = 0;
            int not = 0;
            if(prices[i] >= prices[prev]) {
                sold = helper(i + 2, -1, prices) + prices[i] - prices[prev];
                not = helper(i + 1, prev, prices);
            }else{
                not = helper(i + 1, prev, prices);
            }
            
            return dp[i][prev + 1] = Math.max(sold, not);
        }
    }
}