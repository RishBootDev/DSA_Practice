public class SubsetSumProblem {

    public static boolean subsetSumUsingRecursion(int arr[], int sum, int i) {

        if (sum == 0)
            return true;

        if (i >= arr.length)
            return false;

        if (arr[i] > sum)
            return subsetSumUsingRecursion(arr, sum, i + 1);

        boolean take = subsetSumUsingRecursion(arr, sum - arr[i], i + 1);
        boolean notTake = subsetSumUsingRecursion(arr, sum, i + 1);

        return take || notTake;
    }

    public static boolean subsetSumUsingMemoization(int arr[], int sum, int i, int dp[][]) {

        if (sum == 0)
            return true;

        if (i >= arr.length)
            return false;

        if (dp[sum][i] != -1)
            return dp[sum][i] == 1;

        boolean result;

        if (arr[i] > sum) {
            result = subsetSumUsingMemoization(arr, sum, i + 1, dp);
        } else {
            boolean take = subsetSumUsingMemoization(arr, sum - arr[i], i + 1, dp);
            boolean notTake = subsetSumUsingMemoization(arr, sum, i + 1, dp);

            result = take || notTake;
        }
        dp[sum][i] = result ? 1 : 0;

        return result;
    }
}