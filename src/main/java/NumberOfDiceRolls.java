public class NumberOfDiceRolls {


    // this dp approach works well and clearly solves 59/62 test cases
    // now completely solving this question by taking mod
        private Integer dp[][];
        private int MOD = 1_000_000_007;

        public int numRollsToTarget(int n, int k, int target) {

            dp = new Integer[n + 1][target + 1];

            return helper(n, k, target);
        }

        public int helper(int n, int k, int target) {

            if (n == 0 && target == 0) {
                return 1;
            }
            if (n == 0 || target < 0) {
                return 0;
            }
            if (dp[n][target] != null) {
                return dp[n][target];
            }

            int count = 0;
            for (int j = 1; j <= k; j++) {
                count = (count + helper(n - 1, k, target - j)) % MOD;
            }

            return dp[n][target] = count;
        }

}
