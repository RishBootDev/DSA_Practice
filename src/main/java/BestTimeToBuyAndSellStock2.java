public class BestTimeToBuyAndSellStock2 {

    public int maxProfit(int[] prices) {
        return helper(0, -1, prices);
    }

    public int helper(int i, int prev, int prices[]) {
        if(i >= prices.length) return 0;

        if(prev == -1) {
            int take = helper(i + 1, i, prices);
            int not = helper(i + 1, prev, prices);
            return Math.max(take, not);
        }else {
            if(prices[i] >= prices[prev]) {
                int sold = helper(i + 1, -1, prices) + prices[i] - prices[prev];
                int soldAndPurchased = helper(i + 1, i + 1, prices);
                int not = helper(i + 1, prev, prices);
                return Math.max(sold, Math.max(soldAndPurchased, not));
             }
            else return helper(i + 1, prev, prices);
        }
    }
}
