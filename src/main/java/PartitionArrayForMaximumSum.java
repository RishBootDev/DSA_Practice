public class PartitionArrayForMaximumSum {

    Integer dp[];
    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.dp = new Integer[arr.length];
        return helper(arr, 0, k, Integer.MIN_VALUE);
    }

    public int helper(int[] arr, int i, int k, int max) {
        if (i == arr.length) {
            return 0;
        }
        if(dp[i] != null) return dp[i];
        int sum = 0;
        int count = 1;

        for (int j = i; j < i + k && j < arr.length; j++) {
            max = Math.max(max, arr[j]);
            int take = helper(arr, j + 1, k, Integer.MIN_VALUE) + count * max;

            sum = Math.max(sum, take);
            count++;
        }

        return dp[i] = sum;
    }
}
