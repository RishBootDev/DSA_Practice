class Solution {

    Integer dp [];

    public int climbStairs(int n, int[] costs) {
        dp = new Integer[n];
        return helper(0, n, costs);
    }

    public int helper(int curr, int n, int[] costs) {

        if(curr == n) {
            return 0;
        }

        if(dp[curr] != null) return dp[curr];

        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        int three = Integer.MAX_VALUE;

        if(curr + 1 <= n) {
            one = helper(curr + 1, n, costs)+ costs[curr]+ 1;
        }

        if(curr + 2 <= n) {
            two = helper(curr + 2, n, costs)+ costs[curr + 1]+ 4;
        }

        if(curr + 3 <= n) {
            three = helper(curr + 3, n, costs) + costs[curr + 2]+ 9;
        }

        return dp[curr] =  Math.min(one, Math.min(two, three));
    }
}