import java.util.Arrays;

public class ClimbingStairs {

    public static void main(String[] args) {

        int n = 8;
        int []dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(climbStais(n, dp));

    }

    public static int climbStais(int n, int dp[]) {

        if (n < 0) return 0;
        if (n == 0) return 1;

        if (dp[n] != -1) return dp [n];

        return dp[n] = climbStais(n-1, dp) + climbStais(n-2, dp) + climbStais(n-3, dp);
    }

    public static int climbStairsBottomUp(int n) {
        if (n <= 2) return n;

        int dp[] = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
