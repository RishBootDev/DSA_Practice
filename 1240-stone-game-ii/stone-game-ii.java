class Solution {
   
    Integer dp[][][];
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        dp = new Integer[n][n + 1][2];
        return helper(piles, 0, 1, 1);
    }

    public int helper(int piles[], int i, int temp, int m) {
        if(i >= piles.length) return 0;

        if(dp[i][m][temp] != null)
            return dp[i][m][temp];

        if(temp == 1) {
            int ans = Integer.MIN_VALUE;
            for(int j = 1; j <= 2 * m && i + j <= piles.length; j++) {
                int pp = 0;
                for(int k = i; k < i + j; k++) {
                    pp += piles[k];
                }
                ans = Math.max(ans, pp + helper(piles, i + j, 0, Math.max(m, j)));
            }
            return dp[i][m][temp] = ans;
        } else {
            int ans = Integer.MAX_VALUE;
            for(int j = 1; j <= 2 * m && i + j <= piles.length; j++) {
                ans = Math.min(ans, helper(piles, i + j, 1, Math.max(m, j)));
            }
            return dp[i][m][temp] = ans;
        }
    }
}