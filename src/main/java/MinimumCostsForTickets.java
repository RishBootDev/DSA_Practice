import java.util.Arrays;

class MinimumCostsForTickets {

    public int mincostTickets(int[] days, int[] costs) {
        int dp [] = new int[days.length];
        Arrays.fill(dp, -1);
        return helper(days, 0, costs, dp);
    }

    public int helper(int[] days, int i, int[] costs, int dp[]) {

        if(i >= days.length) {
            return 0;
        }

        if(dp[i] != -1) return dp[i];

        int cost1 = costs[0] + helper(days, i + 1, costs, dp);

        int j = i;
        while(j < days.length && days[j] < days[i] + 7) {
            j++;
        }

        int cost2 = costs[1] + helper(days, j, costs, dp);
        j = i;
        while(j < days.length && days[j] < days[i] + 30) {
            j++;
        }

        int cost3 = costs[2] + helper(days, j, costs, dp);

        return dp[i] = Math.min(cost1, Math.min(cost2, cost3));
    }
}