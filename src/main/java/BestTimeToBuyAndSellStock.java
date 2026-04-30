public class BestTimeToBuyAndSellStock
{
    public int maxProfit(int[] prices) {

       return helper(prices, 0);

    }
    public int helper(int [] prices, int i) {

        if(i == prices.length) {
            return 0;
        }
        // not take
        int notTake = helper(prices, i + 1);
        // take
        int take = 0;
        for (int j = i; j < prices.length; j++) {
            if(prices[i] - prices[j]>=0)
               take += helper(prices, j);
        }
        return Math.max(take, notTake);
    }

}
