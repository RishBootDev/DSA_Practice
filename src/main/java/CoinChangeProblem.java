public class CoinChangeProblem {


    public static int coinChangeUsingRecursion(int arr[], int sum) {

        if (sum == 0)
            return 0;
        if (sum < 0)
            return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {

            int res = coinChangeUsingRecursion(arr, sum - arr[i]);

            if (res != Integer.MAX_VALUE)
                min = Math.min(min, res + 1);
        }

        return min;
    }

}
