class Solution {

    Long[][][] dp;

    public long numberOfWays(String s) {
        dp = new Long[s.length()][3][3];
        return helper(s, 0, 0, 2);
    }

    public long helper(String s, int i, int count, int prev) {
        if (count == 3) return 1;
        if (i == s.length()) return 0;

        if (dp[i][count][prev] != null) {
            return dp[i][count][prev];
        }

        long ans = helper(s, i + 1, count, prev);

        int curr = s.charAt(i) - '0';

        if (prev == 2 || prev != curr) {
            ans += helper(s, i + 1, count + 1, curr);
        }

        return dp[i][count][prev] = ans;
    }
}