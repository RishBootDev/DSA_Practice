class Solution {
    int MOD = 1000000007;
    Integer[][] dp;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        dp = new Integer[locations.length][fuel + 1];
        return helper(locations, start, finish, fuel);
    }

    public int helper(int loc[], int i, int end, int fuel) {
        if(fuel < 0) return 0;
        if(dp[i][fuel] != null) return dp[i][fuel];

        int count = 0;

        if(i == end) count = 1;

        for(int j = 0; j < loc.length; j++) {
            if(i != j && fuel >= Math.abs(loc[i] - loc[j])) {
                count = (count + helper(loc, j, end, fuel - Math.abs(loc[i] - loc[j]))) % MOD;
            }
        }

        return dp[i][fuel] = count;
    }
}