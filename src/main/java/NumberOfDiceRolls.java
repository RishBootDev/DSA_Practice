public class NumberOfDiceRolls {

        public int numRollsToTarget(int n, int k, int target) {
            return helper(n, k, target);
        }

        public int helper(int n, int k, int target) {

            if (n == 0 && target == 0) {
                return 1;
            }
            if (n == 0 || target < 0) {
                return 0;
            }
            int count = 0;

            for (int j = 1; j <= k; j++) {
                count += helper(n - 1, k, target - j);
            }
            return count;
        }

}
