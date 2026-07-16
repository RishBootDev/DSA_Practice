class Solution {

    int[][] dp;

    public int numDistinct(String s, String t) {

        dp = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(s, t, 0, 0);
    }

    public int helper(String s, String t, int i, int j) {

        if (j == t.length()) {
            return 1;
        }

        if (i == s.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {

            // take
            int take = helper(s, t, i + 1, j + 1);
            // not take
            int notTake = helper(s, t, i + 1, j);
            return dp[i][j] = take + notTake;
        }
        // not take
        return dp[i][j] = helper(s, t, i + 1, j);
    }
}