import java.util.ArrayList;
import java.util.List;

public class BestTimeToBuyAndSellStocksUsingStrategy {

    public long maxProfit(int[] prices, int[] strategy, int k) {

        int pre[] = new int[prices.length];
        long sum = 0;
        for (int i = 0; i < prices.length; i++) {
            sum += ((long) strategy[i] * prices[i]);
        }
        long max = Long.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int end = k;
            if(i + end < prices.length) {
                long first = pre[i] - pre[0];
                long last = pre[prices.length - 1] - pre[end];
                long score = score(prices, i, end) + first + last;
                max = Math.max(max, score);
            }
        }
        return max;

    }

    public long score(int prices[], int i, int j) {
        int temp = i + (j - i) / 2;
        long ans = 0;
        for (int k = i; k < j; k++) {
            if (k >= temp) {
                ans += prices[i];
            }
        }
        return ans;
    }

}
