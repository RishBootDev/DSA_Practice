public class BestTimeToBuySellStock3 {

    public int maxProfit(int[] prices) {
       return helper(0, -1, prices, 0);
    }

    public int helper(int i,int prev, int[] prices, int count) {

        if(i == prices.length) return 0;

        if(prev == -1) {
            // take
            int take = helper(i + 1, i, prices, count);
            // not take
            int not = helper(i + 1, prev, prices, count);
            return Math.max(take, not);
        }else {
            if(count < 3) {
                // sold
                if(prices[i] >= prices[prev]) {
                    int sold = (prices[i] - prices[prev]) + helper(i + 1, -1, prices, count+1);
                    int not = helper(i + 1, prev, prices, count);
                    return Math.max(sold, not);
                }else {
                    return helper(i + 1, prev, prices, count);
                }
            }else {
                return 0;
            }
        }
    }
}
