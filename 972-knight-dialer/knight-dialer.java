class Solution {

    Integer dp[][][];
    int MOD = 1000000007;
    
    public int knightDialer(int n) {

        int ans = 0;
        dp = new Integer[n][4][3];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if(check(i, j)) {
                    ans = (ans + helper(n - 1, i, j)) % MOD;
                }
            }
        }
        return ans;
    }

    public int helper(int n, int i , int j) {

        if(n == 0) {
            return 1;
        }

        int count = 0;

        if(dp[n][i][j] != null) return dp[n][i][j];
        // move up
        if(check(i - 2, j - 1))
            count = (count + helper(n - 1, i - 2, j - 1)) % MOD;

        if(check(i - 2, j + 1))
            count = (count + helper(n - 1, i - 2, j + 1)) %MOD;
        
        // move down 
        if(check(i + 2, j - 1))
            count = (count + helper(n - 1, i + 2, j - 1)) %MOD;

        if(check(i + 2, j + 1))
            count = (count + helper(n - 1, i + 2, j + 1)) % MOD;
        
        // move left 
        if(check(i - 1, j - 2))
            count = (count + helper(n - 1, i - 1, j - 2)) %MOD;

        if(check(i - 1, j + 2))
            count = (count + helper(n - 1, i - 1, j + 2)) %MOD;
        
        // move right 
        if(check(i + 1, j - 2))
            count = (count + helper(n - 1, i + 1, j - 2)) % MOD;

        if(check(i + 1, j + 2))
            count =(count + helper(n - 1, i + 1, j + 2)) % MOD;
        
        return dp[n][i][j] = count;
    }

    public boolean check(int i, int j) {

        if(i < 0 || j < 0) {
            return false;
        }
        if(i >= 4 || j >= 3) {
            return false;
        }
        if(i == 3 && (j == 0 || j == 2)) {
            return false;
        }
        return true;
    }
}