class Solution {

    int MOD = 1_000_000_007;
    Integer[] dp;

    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new Integer[high + 1];
        return helper(0, low, high, zero, one);
    }

    public int helper(int len, int low, int high, int zero, int one) {

        if (len > high) {
            return 0;
        }

        if (dp[len] != null) {
            return dp[len];
        }

        long count = 0;

        if (len >= low) {
            count = 1;
        }

        count = (count + helper(len + zero, low, high, zero, one)) % MOD;
        count = (count + helper(len + one, low, high, zero, one)) % MOD;

        return dp[len] = (int) count;
    }
}