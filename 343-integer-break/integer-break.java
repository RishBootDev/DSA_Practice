class Solution {

    Integer [] dp;
    public int integerBreak(int n) {
        dp = new Integer[n + 1];
        return helper(n);
    }

    public int helper(int n) {
        if (n == 1) return 1;
        if(dp[n] != null) return dp[n];
        int max = 0;

        for (int i = 1; i < n; i++) {
            int take = i * (n - i);
            int split = i * helper(n - i);

            max = Math.max(max, Math.max(take, split));
        }

        return dp[n] = max;
    }
}