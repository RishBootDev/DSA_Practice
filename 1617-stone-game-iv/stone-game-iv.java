class Solution {

    Boolean dp[];

    public boolean winnerSquareGame(int n) {
        dp = new Boolean[n + 1];
        return helper(n);
    }

    public boolean helper(int n) {
        if(n == 0) return false;

        if(dp[n] != null) return dp[n];

        for(int i = 1; i * i <= n; i++) {
            if(!helper(n - i * i)) {
                return dp[n] = true;
            }
        }

        return dp[n] = false;
    }
}