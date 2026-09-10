class Solution {

    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        long[] originalPre = new long[n + 1];
        long[] pre = new long[n + 1];

        for (int i = 0; i < n; i++) {
            originalPre[i + 1] = originalPre[i] + (long) prices[i] * strategy[i];
            pre[i + 1] = pre[i] + prices[i];
        }

        long op = originalPre[n];
        long max = op;

        int half = k / 2;

        for (int start = 0; start + k <= n; start++) {
            int mid = start + half;
            int end = start + k;

            long removed = originalPre[end] - originalPre[start];
            long added = pre[end] - pre[mid];

            long profit = op - removed + added;

            max = Math.max(max, profit);
        }

        return max;
    }
}