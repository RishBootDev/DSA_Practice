class Solution {

    Integer dp[][];
    public int getMoneyAmount(int n) {
        dp = new Integer[n+1][n+1];
        return helper(1, n);
    }

    public int helper(int l, int h) {

        if (l >= h) {
            return 0;
        }

        if(dp[l][h] != null) return dp[l][h];
        int ans = Integer.MAX_VALUE;

        for (int k = l; k <= h; k++) {

            int left = helper(l, k - 1);
            int right = helper(k + 1, h);
            int cost = k + Math.max(left, right);
            ans = Math.min(ans, cost);
        }
        return dp[l][h] = ans;
    }
}