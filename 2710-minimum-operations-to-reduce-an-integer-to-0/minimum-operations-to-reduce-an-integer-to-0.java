class Solution {

    Integer[] dp;

    public int minOperations(int n) {
        dp = new Integer[n + 1];
        return helper(n);
    }

    public int helper(int n) {

        if (n == 0)
            return 0;

        if (dp[n] != null)
            return dp[n];

        int ans = Integer.MAX_VALUE;

        for (int p = 1; p <= 2 * n; p <<= 1) {
            int next = Math.abs(n - p);

            if (next == n)
                continue;

            ans = Math.min(ans, 1 + helper(next));
        }
        return dp[n] = ans;
    }
}