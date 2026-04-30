import java.util.Arrays;

public class CoinChangeTwo {

    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount +1];
        for(int[] d : dp) Arrays.fill(d, -1);
        return helper(amount, coins, 0, 0, dp);
    }
    public int helper(int amount, int[] coins, int index, int sum, int [][]dp) {

        if (sum > amount) {
            return 0;
        }
        if (sum == amount) {
            return 1;
        }
        if (index == coins.length) {
            return 0;
        }

        if(dp[index][sum] != -1) return dp[index][sum];

        int take = helper(amount, coins, index, sum + coins[index], dp);
        int notTake = helper(amount, coins, index + 1, sum, dp);
        return dp[index][sum] = take + notTake;
    }
}
