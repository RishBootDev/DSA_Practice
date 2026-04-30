public class CountSortedVowelStrings {

    Integer[][] dp;

    public int countVowelStrings(int n) {

        dp = new Integer[6][n + 1];
        return helper(n, 1, 0);
    }

    public int helper(int n, int i, int len) {

        if(len == n) {
            return 1;
        }
        if(dp[i][len] != null) {
            return dp[i][len];
        }
        int count = 0;
        for(int k = i; k <= 5; k++) {
            count += helper(n, k, len + 1);
        }
        return dp[i][len] = count;
    }
}
